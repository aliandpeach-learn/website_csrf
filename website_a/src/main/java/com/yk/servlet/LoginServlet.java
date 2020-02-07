package com.yk.servlet;

import com.yk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author Acer
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 2776963467705681392L;

    private Logger logger = LoggerFactory.getLogger("servlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("LoginServlet#doGet");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("LoginServlet#doPost");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("LoginServlet#service");

        req.getSession().invalidate();
        byte[] b = new byte[32];
        new SecureRandom().nextBytes(b);
        req.getSession().setAttribute("token", new BigInteger(1, b).toString(16));
        String x = bytesToHexString(b);
        boolean f = x.equalsIgnoreCase(new BigInteger(1, b).toString(16));
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        req.getSession().setAttribute("user", new User(u, p));
        resp.sendRedirect(req.getContextPath() + "/add.jsp");
    }

    /**
     * 字节数组转十六进制
     *
     * @param data
     * @return     
     */
    public String bytesToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            String t = Integer.toHexString(0xFF & bArr[i]);
            if (t.length() < 2) {
                sb.append(0);
            }
            sb.append(t.toUpperCase());
        }

        return sb.toString();
    }

    /**
     * 十六进制转换为字节数组
     *
     * @param s
     * @return     
     */
    public static byte[] hexStringToByteArray(String s) {
        //十六进制转byte数组
        int len = s.length();
        byte[] bs = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            bs[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return bs;
    }
}
