<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/9/9
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <h1>欢迎登录</h1>
    <form method = "POST" action = "/index.jsp" target = "_blank">
        <input type = "text"  name = "user">
        <input type = "password"  name = "password">
        <input type = "submit" value = "登录">
    </form>

    在线会员人数：<%=application.getAttribute("onlineMember") %><br/>
    当前在线人数：<%=application.getAttribute("onlineNumber") %><br/>
    历史访问人数：<%=application.getAttribute("totalNumber") %><br/>

</head>
<body>

</body>
</html>
