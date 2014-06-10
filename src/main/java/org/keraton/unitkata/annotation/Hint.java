package org.keraton.unitkata.annotation;

import java.lang.annotation.*;

/**
 * Created by bowiesanggajayabrotosumpeno on 09/06/2014.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Hint {

    public String value();
}