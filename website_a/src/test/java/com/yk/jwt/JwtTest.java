package com.yk.jwt;

import com.alibaba.fastjson.JSON;
import com.yk.model.User;
import io.jsonwebtoken.Claims;

import java.text.SimpleDateFormat;

/**
 * 描述
 *
 * @author yangk
 * @version 1.0
 * @since 2021/11/16 17:35:46
 */
public class JwtTest
{
    public static void main(String[] args)
    {
        User user = new User();
        user.setId("10");
        user.setName("张三");
        user.setPassword("123123");
        // jwt所面向的用户，放登录的用户名等
        String subject = JSON.toJSONString(user);
        try
        {
            // "Jack"是jwt签发者，"李四"是jwt接收者
            String jwt = JwtUtil.createJWT("Jack", "李四", subject);
            System.out.println("JWT：" + jwt);
            System.out.println("JWT长度：" + jwt.length());
            System.out.println("\njwt三个组成部分中间payload部分的解密：");
            Claims c = JwtUtil.parseJWT(jwt);
            System.out.println("jti用户id：" + c.getId());
            System.out.println("iat登录时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getIssuedAt()));
            System.out.println("iss签发者：" + c.getIssuer());
            System.out.println("sub用户信息列表：" + c.getSubject());
            System.out.println("exp过期时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getExpiration()));
            System.out.println("aud接收者：" + c.getAudience());
            System.out.println("登录的用户名：" + c.get("username"));
            // 或
            System.out.println("登录的用户名：" + c.get("username", String.class));
            System.out.println("登录的密码：" + c.get("password", String.class));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
