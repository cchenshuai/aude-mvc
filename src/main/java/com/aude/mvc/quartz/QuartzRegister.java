package com.aude.mvc.quartz;

import com.aude.mvc.util.Logs;
import com.aude.mvc.ioc.IocBeanContext;
import com.aude.mvc.util.ClassTool;
import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;


/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/11/15 0015
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("all")
public class QuartzRegister {

    private static final Logger log = Logs.get();

    /**
     * 注册定时任务管理器
     *
     * @param newIocBeanKey 放入ioc中需要一个IOC名称
     * @return Scheduler
     */
    public static <T> T registerScheduler(String newIocBeanKey) {
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            mvcJobFactory mvcJobFactory = new mvcJobFactory();
            IocBeanContext.me().setBean(ClassTool.getIocBeanName(mvcJobFactory.class), mvcJobFactory);
            scheduler.setJobFactory(mvcJobFactory);
            IocBeanContext.me().setBean(newIocBeanKey, scheduler);
        } catch (Exception e) {
            log.error("注册定时任务管理器发生错误!", e);
        }
        return (T) scheduler;
    }

}
