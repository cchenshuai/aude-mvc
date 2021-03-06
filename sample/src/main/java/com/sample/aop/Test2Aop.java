package com.sample.aop;

import com.aude.mvc.annotation.IocBean;
import com.aude.mvc.aop.InterceptorProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/10/9 0009
 * To change this template use File | Settings | File Templates.
 */
@IocBean("test2aop")
public class Test2Aop extends InterceptorProxy {

    private static final Logger logger = Logger.getRootLogger();


    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.debug("---------- before test2aop ----------");
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
    }

    @Override
    protected void exception(Class<?> cls, Method method, Object[] params, Throwable e) {

    }

    @Override
    protected void finalize() {

    }
}
