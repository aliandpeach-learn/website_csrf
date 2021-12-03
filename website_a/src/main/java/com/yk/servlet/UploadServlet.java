package com.yk.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
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
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
        InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        BufferedReader reader1 = new BufferedReader(reader);
        String line = null;
        while ((line = reader1.readLine()) != null)
        {
            System.out.println(line);
        }

        try
        {
            // 获取getParts会报 '由于没有提供multi-part配置,无法处理parts'
            // 这里也能看出来 getParts只是servlet提供的接口，具体实现还需要相应的第三方包 例如spring-boot 中的embed-tomcat就是通过修改tomcat源码直接实现了该接口
            Collection<Part> parts = req.getParts();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        logger.info("UploadServlet#service");
    }
}
