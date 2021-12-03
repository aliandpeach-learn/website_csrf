package com.yk.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 描述
 *
 * @author yangk
 * @version 1.0
 * @since 2021/12/03 12:12:28
 */
public class SessionListener implements HttpSessionListener
{
    private Logger logger = LoggerFactory.getLogger("servlet");

    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
//        se.getSession().setMaxInactiveInterval();
        logger.info("session created..." + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        logger.info("session destroyed..." + se.getSession().getId());
    }
}
