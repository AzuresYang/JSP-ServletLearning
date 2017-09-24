<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/8/4
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetHeader</title>
</head>
<body>
    <%
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements()){
            String name = headers.nextElement();
            String value = request.getHeader(name);
            if(null == value || "".equals(value))
                value = "null";
        %>
    <p>表头名称：<%= name%>&nbsp:&nbsp;对应的值：<%= value%></p>
    <% } %>
    %>
</body>
</html>
