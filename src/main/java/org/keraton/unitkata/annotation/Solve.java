package org.keraton.unitkata.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Solve {

    static class None extends Throwable {
        private static final long serialVersionUID= 1L;
        private None() {
        }
    }

    String hint();
    int order();
    Class<? extends Throwable> expected() default None.class;

}