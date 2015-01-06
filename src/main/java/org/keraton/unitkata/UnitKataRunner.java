package org.keraton.unitkata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.keraton.unitkata.annotation.Solution;
import org.keraton.unitkata.annotation.Summary;
import org.keraton.unitkata.annotation.Verifier;
import org.keraton.unitkata.exception.NoSolutionException;
import org.keraton.unitkata.exception.NoVerifierException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


public class UnitKataRunner extends BlockJUnit4ClassRunner {

    private Object objectTest;

    public UnitKataRunner(Class<?> klass) throws InitializationError {
        super(klass);
        try {
            objectTest = klass.newInstance();
        } catch (InstantiationException e) {
            throw new InitializationError(e);
        } catch (IllegalAccessException e) {
            throw new InitializationError(e);
        }
    }

    @Override
    public void run(final RunNotifier notifier) {
        if (isVerified(notifier))
            super.run(notifier);
    }

    private boolean isVerified(RunNotifier notifier) {
        try {
            return runVerificatorProcess(notifier, objectTest);
        } catch (Throwable e) {
            notifyFailure(notifier, e);
        }
        return false;
    }

    private void notifyFailure(RunNotifier notifier, Throwable e) {
        EachTestNotifier testNotifier= new EachTestNotifier(notifier,getDescription());
        testNotifier.addFailure(e);
    }

    private boolean runVerificatorProcess(RunNotifier notifier, Object objectTest) throws
            InstantiationException, IllegalAccessException, InitializationError {
        if (hasTest(objectTest)) {
            runVerificatorTest(notifier, objectTest);
        }
        else {
            throwNoTestViolation(notifier, objectTest);
        }

        return true;
    }

    private void runVerificatorTest(RunNotifier notifier, Object objectTest) throws IllegalAccessException, InstantiationException, InitializationError {
        Field[] fields = objectTest.getClass().getDeclaredFields();

        Object solution = null;
        for (Field field : fields){
            if (field.getAnnotation(Solution.class) != null) {
                field.setAccessible(true);
                field.set(objectTest, field.getType().newInstance());
                solution = field.getType().newInstance();
            }
        }

        if (null == solution)
            throw new NoSolutionException("There is no solution in the : " + objectTest.getClass());

        Verifier verifier = objectTest.getClass().getAnnotation(Verifier.class);

        if (null == verifier)
            throw new NoVerifierException("No verifier for " + objectTest.getClass());

        Class clazz = verifier.value();
        boolean showHint = verifier.showHint();
        Runner runner = new SolutionRunner(clazz, solution, showHint);
        runner.run(notifier);
    }

    private void throwNoTestViolation(RunNotifier notifier, Object objectTest) {
        final Summary summary = objectTest.getClass().getAnnotation(Summary.class);
        if (summary != null) {
            AssumptionViolatedException assumptionViolatedException = new AssumptionViolatedException(summary.value()) {

                public void describeTo(org.hamcrest.Description description) {
                     description.appendText("\n \n========================= UNIT KATA ==============================\n" + summary.value());
                }
                                                                      };
            notifier.fireTestAssumptionFailed(new Failure(Description.createSuiteDescription(objectTest.getClass()),
                    assumptionViolatedException));
        }
    }

    private boolean hasTest(Object objectTest) {
        boolean hasTest = false;
        Method[] methods = objectTest.getClass().getMethods();
        for(Method method: methods) {
            if (method.getAnnotation(Test.class) != null) {
                hasTest = true;
                break;
            }
        }
        return hasTest;
    }

    @Override
    protected void validateInstanceMethods(List<Throwable> errors) {
        validatePublicVoidNoArgMethods(After.class, false, errors);
        validatePublicVoidNoArgMethods(Before.class, false, errors);
        validateTestMethods(errors);
    }

    @Override
    protected Object createTest() throws Exception {
        return objectTest;
    }

}
