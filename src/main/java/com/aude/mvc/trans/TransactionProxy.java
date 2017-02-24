package com.aude.mvc.trans;

import com.aude.mvc.aop.proxy.ProxyChain;
import com.aude.mvc.aop.proxy.Proxy;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/11/1 0001
 * To change this template use File | Settings | File Templates.
 */
public class TransactionProxy implements Proxy {

    /**
     * 事务隔离级别
     */
    public int level;

    public TransactionProxy(int level) {
        this.level = level;
    }

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object re = null;
        try {
            Trans.begin(level);
            re = proxyChain.invokeSuper();
            Trans.commit();
        } catch (Throwable e) {
            Trans.rollback();
            throw e;
        } finally {
            Trans.close();
        }
        return re;
    }

}
