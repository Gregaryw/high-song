package com.high.annotation;

import com.high.core.enums.IdType;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TableId {
    String value() default "";

    IdType type() default IdType.NONE;
}
