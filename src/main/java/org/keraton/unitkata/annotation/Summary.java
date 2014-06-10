package org.keraton.unitkata.annotation;

import java.lang.annotation.*;

/**
 * Created by bowiesanggajayabrotosumpeno on 10/06/2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Summary {

    public String value();
}
