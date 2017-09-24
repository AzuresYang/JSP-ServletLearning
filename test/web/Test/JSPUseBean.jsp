<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/9/9
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id = "user" class="cc.openHome.UserBean"/>
<jsp:setProperty name = "user" property = "name" value = "蔚蓝"/>
<html>
<head>
    <title>HelloBean</title>
</head>
<body>
        Wecome To Test Page.
    <br>
        <h1><jsp:getProperty name = "user" property = "name"/>  Login Successfully</h1>

</body>
</html>
