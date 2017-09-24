<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/8/3
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<html>
  <head>
    <title>"First Title"</title>
  </head>
   <%!
   String sayDudulo(){

       return "Hello!";
       }
   %>
  <%!
     String name = "azure";
  %>
  <body>
  <%out.println(sayDudulo());%>

  </br>
  <%= new Date()%>>
  <br>

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
