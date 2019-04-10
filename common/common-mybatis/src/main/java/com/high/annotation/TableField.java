package com.high.annotation;

import com.high.core.enums.FieldFill;
import com.high.core.enums.FieldStrategy;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TableField {
    String value() default "";

    String el() default "";

    boolean exist() default true;

    String condition() default "";

    String update() default "";

    FieldStrategy strategy() default FieldStrategy.DEFAULT;

    FieldFill fill() default FieldFill.DEFAULT;

    boolean select() default true;
}

