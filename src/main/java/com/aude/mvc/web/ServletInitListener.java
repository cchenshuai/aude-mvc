package com.aude.mvc.web;


import com.aude.mvc.cache.MvcsManager;
import com.aude.mvc.mvc.view.ViewsRegister;
import com.aude.mvc.scanner.ClassHelper;
import com.aude.mvc.util.Logs;
import com.google.gson.Gson;
import com.aude.mvc.constant.Constant;
import com.aude.mvc.ioc.IocBeanContext;
import com.aude.mvc.scanner.PropertiesScans;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/5/8 0008
 * To change this template use File | Settings | File Templates.
 */
public class ServletInitListener implements ServletContextListener {
    private static final Logger logger = Logs.get();


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载全局配置文件
        PropertiesScans.init();
        //扫描关键注解
        ClassHelper.init();
        //注册默认视图
        ViewsRegister.RegisterDefaultView();
        //执行自定义启动类
        handlerInit(servletContextEvent);
        //初始化IOC
        IocBeanContext.me().init(ClassHelper.classes);
        logger.info("环境初始化成功");
        logger.debug("UrlMapping:" + new Gson().toJson(MvcsManager.urlMappingList()));
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //执行自定义销毁类
        handlerDestroy(servletContextEvent);
        logger.info("环境销毁成功");
    }

    private void handlerInit(ServletContextEvent servletContextEvent) {
        try {
            WebSetup setup = (WebSetup) MvcsManager.getSetupCache(Constant.WEB_SETUP);
            setup.init(servletContextEvent);
            MvcsManager.putSetupCache(Constant.WEB_SETUP, setup);
        } catch (Exception e) {
            logger.error("环境初始化时发生错误！", e);
            throw new RuntimeException("环境初始化时发生错误！", e);
        }
    }

    private void handlerDestroy(ServletContextEvent servletContextEvent) {
        try {
            WebSetup setup = (WebSetup) MvcsManager.getSetupCache(Constant.WEB_SETUP);
            setup.destroy(servletContextEvent);
        } catch (Exception e) {
            logger.error("环境销毁时发生错误！", e);
            throw new RuntimeException("环境销毁时发生错误！", e);
        }
    }
}
