package com.yk.filter;

import com.alibaba.druid.util.StringUtils;
import com.yk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger("filter");

    private static List<String> actions = new ArrayList<>();

    private static List<String> resources = new ArrayList<>();

    static {
        resources.add(".jsp");
        resources.add(".css");
        resources.add(".jpeg");
        resources.add(".png");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (null != filterConfig && null != filterConfig.getInitParameter("validate")) {
            String v = filterConfig.getInitParameter("validate");
            actions.addAll(Arrays.asList(v.split(";")));
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (null == req || null == resp) {
            return;
        }
        if (!(req instanceof HttpServletRequest) || !(resp instanceof HttpServletResponse)) {
            return;
        }
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (session == null) {
            logger.error("session is null!");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        String url = request.getRequestURI();
        StringBuffer urlb = request.getRequestURL();
        if (validate(url)) {
            chain.doFilter(request, response);
            return;
        }

        Object u = session.getAttribute("user");
        if (null == u) {
            logger.error("u is null!");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        User user = (User) u;
        if (null == user || StringUtils.isEmpty(user.getName())) {
            logger.error("user is null!");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private boolean validate(String url) {
        for (String action : actions) {
            if (url.endsWith(action)) {
                return true;
            }
        }
        for (String action : resources) {
            if (url.endsWith(action)) {
                return true;
            }
        }
        return false;
    }
}
