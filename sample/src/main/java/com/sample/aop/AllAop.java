package com.sample.aop;

import com.aude.mvc.annotation.IocBean;
import com.aude.mvc.aop.proxy.Proxy;
import com.aude.mvc.aop.proxy.ProxyChain;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/10/11 0011
 * To change this template use File | Settings | File Templates.
 */
@IocBean
public class AllAop implements Proxy {

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        System.out.println("执行前");
        Object re = proxyChain.invokeSuper();
        System.out.println("执行后");
        return re;
    }
}
