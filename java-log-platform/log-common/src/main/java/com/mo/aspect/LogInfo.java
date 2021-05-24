package com.mo.aspect;

import java.lang.annotation.*;

/**
 * Created by mo on 2021/5/24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogInfo {
    String value() default "";
}
