package org.keraton.unitkata;

import org.junit.internal.runners.statements.ExpectException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Solve;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bowiesanggajayabrotosumpeno on 05/06/2014.
 */
public class SolutionRunner extends BlockJUnit4ClassRunner {

    private Object solutionVerifier;
    private boolean isAlreadyKO = false;
    private final boolean showHint;

    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws org.junit.runners.model.InitializationError if the test class is malformed.
     */
    public SolutionRunner(Class<?> klass, Object solution, boolean showHint) throws InitializationError {
        super(klass);
        try {
            solutionVerifier = super.createTest();
            this.showHint = showHint;

            Field[] fields = solutionVerifier.getClass().getDeclaredFields();
            for(Field field: fields) {
                if (field.getAnnotation(Solution.class)!= null) {
                    field.setAccessible(true);
                    field.set(solutionVerifier, solution);
                }
            }
        } catch (Exception e) {
            throw new InitializationError(e);
        }
    }

    @Override
    protected Object createTest() throws Exception {
        return solutionVerifier;
    }

    @Override
    public void run(final RunNotifier notifier) {
        notifier.addListener(new RunListener(){

            @Override
            public void testFailure(Failure failure) throws Exception {
                isAlreadyKO = true;
            }

        });
        super.run(notifier);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        if (!isAlreadyKO) {
            super.runChild(method, notifier);
        }
    }

    @Override
    protected Description describeChild(FrameworkMethod method) {
        Solve solve = method.getAnnotation(Solve.class);
        String methodName = showHint
                                ? String.format("(%d) : %s", solve.order(), solve.hint())
                                : String.format("(%d) : No hint allowed", solve.order());

        return Description.createTestDescription(getTestClass().getJavaClass(),
                methodName, method.getAnnotations());
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(Solve.class);

        // Sort failure in order
        Collections.sort(methods, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod o1, FrameworkMethod o2) {
                int order1 = o1.getMethod().getAnnotation(Solve.class).order();
                int order2 = o2.getMethod().getAnnotation(Solve.class).order();
                return order1 - order2;
            }
        });

        return methods;
    }

    @Deprecated
    @Override
    protected Statement possiblyExpectingExceptions(FrameworkMethod method,
                                                    Object test, Statement next) {
        Solve annotation= method.getAnnotation(Solve.class);
        return expectsException(annotation) ? new ExpectException(next,
                getExpectedException(annotation)) : next;
    }

    private Class<? extends Throwable> getExpectedException(Solve annotation) {
        if (annotation == null || annotation.expected() == Solve.None.class)
            return null;
        else
            return annotation.expected();
    }

    private boolean expectsException(Solve annotation) {
        return getExpectedException(annotation) != null;
    }

}
