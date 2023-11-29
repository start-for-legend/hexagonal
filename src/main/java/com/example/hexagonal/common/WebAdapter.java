package com.example.hexagonal.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@interface WebAdapter {

    @AliasFor(annotation = Component.class)
    String value() default "";
}