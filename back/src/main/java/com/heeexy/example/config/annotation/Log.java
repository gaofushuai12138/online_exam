package com.heeexy.example.config.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**模块*/
    String moudle() default "";

    /**描述*/
    String descrption() default "";
}
