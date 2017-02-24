package com.aude.mvc.register;

import com.aude.mvc.dao.Dao;
import com.aude.mvc.dao.DaosRegister;
import com.aude.mvc.mvc.view.ViewsRegister;
import com.aude.mvc.quartz.QuartzRegister;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/12/14 0014
 * To change this template use File | Settings | File Templates.
 */
public class Registers {

    /**
     * 注册视图
     *
     * @param regTypeStr 注册类型
     * @param Viewklass  视图
     */
    public static void view(String regTypeStr, Class<?> Viewklass) {
        ViewsRegister.registerView(regTypeStr, Viewklass);
    }

    /**
     * 注册dao
     *
     * @param newIocBeanKey
     * @param klass
     * @param dataSource
     * @return
     */
    public static Dao dao(String newIocBeanKey, Class<?> klass, DataSource dataSource) {
        return DaosRegister.registerDao(newIocBeanKey, klass, dataSource);
    }

    /**
     * 注册任务
     *
     * @param newIocBeanKey
     * @param <T>
     * @return
     */
    public static <T> T Scheduler(String newIocBeanKey) {
        return QuartzRegister.registerScheduler(newIocBeanKey);
    }


}
