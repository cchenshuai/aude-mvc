package com.aude.mvc.ioc;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/11/9 0009
 * To change this template use File | Settings | File Templates.
 */
public class Ioc {

    private static IocBeanContext iocBeanContext = IocBeanContext.me();

    public static <T> T getBean(String beanKey) {
        return (T) iocBeanContext.getBean(beanKey);
    }

}
