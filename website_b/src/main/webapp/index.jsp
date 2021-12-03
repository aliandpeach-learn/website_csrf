<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    org.slf4j.Logger logger = LoggerFactory.getLogger("servlet");
    Logger logger2 = Logger.getLogger("servlet");
    logger.info("index.jsp =============");
    logger2.info("index2.jsp =============");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="add" action="127.0.0.1:65532/a/add" method="post" enctype="application/x-www-form-urlencoded">
    something : <input name="add" value="" type="text"/>
    <input type="submit" value="添加"/>
</form>
</body>
</html>
