<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<form name="loginForm" action="<%=request.getContextPath()%>/login" method="post" enctype="application/x-www-form-urlencoded">
    username : <input name="username" value="" type="text"/>
    password : <input name="password" value="" type="password"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
