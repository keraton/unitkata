package org.keraton.unitkata.annotation;

/**
 * Created by bowiesanggajayabrotosumpeno on 09/06/2014.
 */

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Order {
    public int value();
}
