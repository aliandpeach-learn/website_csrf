package com.yk.listener;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class Log4jListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String path = sce.getServletContext().getInitParameter("log4jConfig");
        //log4j.xml文件的读取
        DOMConfigurator.configure(sce.getServletContext().getRealPath("/") + path.replace("/", File.separator).replace("\\", File.separator));
        //log4j.properties文件的读取
//        PropertyConfigurator.configure("conf/log4j.properties");
        org.slf4j.Logger logger = LoggerFactory.getLogger("servlet");
        Logger logger2 = Logger.getLogger("servlet");
        logger.info("contextInitialized slf4j =============");
        logger2.info("contextInitialized2 =============");

        Logger logger3 = Logger.getLogger(Log4jListener.class);
        logger3.info("logger3 Log4jListener.class =============");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
