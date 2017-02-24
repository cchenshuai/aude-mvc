package com.aude.mvc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/10/8 0008
 * To change this template use File | Settings | File Templates.
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

    String value() default "";

}
