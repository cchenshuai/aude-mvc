package com.aude.mvc.annotation;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/6/24 0024
 * To change this template use File | Settings | File Templates.
 */

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface Colum {
    /**
     * 字段名称
     *
     * @return
     */
    String value() default "";
}
