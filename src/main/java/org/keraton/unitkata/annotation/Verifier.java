package org.keraton.unitkata.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Verifier {

    Class<?> value();

    boolean showHint() default true;
}
