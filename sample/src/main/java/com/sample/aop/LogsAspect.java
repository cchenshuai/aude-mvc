package com.sample.aop;

import com.aude.mvc.annotation.Action;
import com.aude.mvc.annotation.Aspect;
import com.aude.mvc.annotation.Inject;
import com.aude.mvc.annotation.IocBean;
import com.aude.mvc.aop.InterceptorProxy;
import com.aude.mvc.dao.Dao;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/10/12 0012
 * To change this template use File | Settings | File Templates.
 * 记录用户访问的所以业务操作
 */
@IocBean
@Aspect(annotation = Action.class, No = 2)
public class LogsAspect extends InterceptorProxy {

    @Inject
    private Dao dao;

    @Override
    protected void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        System.out.println(String.format("LogsAspect用户访问了[%s]的[%s]方法", cls.getName(), method.getName()));
    }

    @Override
    protected void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {

    }

    @Override
    protected void exception(Class<?> cls, Method method, Object[] params, Throwable e) {

    }

    @Override
    protected void finalize() {

    }
}
