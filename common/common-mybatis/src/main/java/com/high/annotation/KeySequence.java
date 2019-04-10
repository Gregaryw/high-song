package com.high.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface KeySequence {
    String value() default "";

    Class clazz() default Long.class;
}
