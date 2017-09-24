<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/9/18
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error Page</h1>
<br>
<%String name = "";
    Map<String, String[]> map =  request.getParameterMap();

    for(String key: map.keySet()){
        out.println("Key："+key);
        out.println("     " );
        String[] strs = map.get(key);
        name = key;
%>
<%
    for(String str: strs){
        out.println("--values："+str);
%>
<br>
<%}%>
<%}%>

<br>
<br>
返回：<a href = <%= request.getHeader("Referer")%>>上一页</a>
</body>
</html>
