package com.chenqi.practice.modules.web.annotation;

import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnnotationTest {
}
