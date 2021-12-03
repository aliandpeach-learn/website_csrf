package com.yk.filter;

import com.alibaba.druid.util.StringUtils;
import com.yk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginFilter implements Filter
{

    private Logger logger = LoggerFactory.getLogger("filter");

    private static List<String> excepts = new ArrayList<>();

    private static List<String> resources = new ArrayList<>();

    static
    {
        resources.add(".css");
        resources.add(".jpeg");
        resources.add(".png");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        if (null != filterConfig && null != filterConfig.getInitParameter("excepts"))
        {
            String v = filterConfig.getInitParameter("excepts");
            excepts.addAll(Arrays.asList(v.split(";")));
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException
    {
        if (null == req || null == resp)
        {
            return;
        }
        if (!(req instanceof HttpServletRequest) || !(resp instanceof HttpServletResponse))
        {
            return;
        }
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (session == null)
        {
            logger.error("session is null!");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        String uri = request.getRequestURI();
        StringBuffer urlString = request.getRequestURL();
        if (validate(uri)) // 例外就放行
        {
            chain.doFilter(request, response);
            return;
        }

        Object u = session.getAttribute("user");
        if (!(u instanceof User))
        {
            logger.error("u is null!");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        User user = (User) u;
        if (StringUtils.isEmpty(user.getName()))
        {
            logger.error("user is null!");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {

    }

    private boolean validate(String url)
    {
        for (String action : excepts)
        {
            if (url.endsWith(action))
            {
                return true;
            }
        }
        for (String action : resources)
        {
            if (url.endsWith(action))
            {
                return true;
            }
        }
        return false;
    }
}
