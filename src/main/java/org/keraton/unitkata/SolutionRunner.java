package org.keraton.unitkata;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.keraton.unitkata.annotation.Hint;
import org.keraton.unitkata.annotation.Order;
import org.keraton.unitkata.annotation.Solution;

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

    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws org.junit.runners.model.InitializationError if the test class is malformed.
     */
    public SolutionRunner(Class<?> klass, Object solution) throws InitializationError {
        super(klass);
        try {
            solutionVerifier = super.createTest();

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
        String methodName = testName(method);
        Hint hint = method.getAnnotation(Hint.class);
        if (hint != null) methodName = String.format("Hint : %s", hint.value());

        return Description.createTestDescription(getTestClass().getJavaClass(),
                methodName, method.getAnnotations());
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> methods = super.computeTestMethods();

        // Sort failure in order
        Collections.sort(methods, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod o1, FrameworkMethod o2) {
                Order order1 = o1.getMethod().getAnnotation(Order.class);
                Order order2 = o2.getMethod().getAnnotation(Order.class);
                if (order1 == null && order2 == null) return 0;
                if (order1 == null && order2 != null) return -1;
                if (order1 != null && order2 == null) return 1;
                return order1.value() - order2.value();
            }
        });

        return methods;
    }

}
