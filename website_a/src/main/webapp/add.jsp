<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/12/26
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="add" action="<%=request.getContextPath()%>/add" method="post" enctype="application/x-www-form-urlencoded">
    something : <input name="add" value="" type="text"/>
    <input name="token" value="<%=request.getSession().getAttribute("token")%>" type="hidden"/>
    <input type="submit" value="添加"/>
</form>
</body>
</html>
