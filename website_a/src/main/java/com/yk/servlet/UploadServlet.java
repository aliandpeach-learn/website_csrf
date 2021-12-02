package com.yk.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * 描述
 *
 * @author yangk
 * @version 1.0
 * @since 2021/11/25 15:12:35
 */
public class UploadServlet extends HttpServlet
{
    private static final long serialVersionUID = -1729148356198944035L;

    private Logger logger = LoggerFactory.getLogger("servlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        logger.info("UploadServlet#doGet");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        logger.info("UploadServlet#doPost");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        logger.info("UploadServlet#service");
        InputStream input = req.getInputStream();
        Collection<Part> parts = req.getParts();
        logger.info("UploadServlet#service");
    }
}
