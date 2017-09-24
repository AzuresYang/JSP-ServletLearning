<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/8/5
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8"%>
<html>
<%!
    String printCookies(Cookie[] cookies){
        String result = "<br>";
        if(null != cookies)
        for(int i = 0; i <cookies.length; i++){
            result += "key:"+cookies[i].getName()+"   value:"+cookies[i].getValue()+"</br>";
        }
        return result;
    }
%>
<head>
    <title>LoginFrame</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        boolean isAutoLogin = false;
        String userName = null;

        if( null != cookies)
        {
            for(int i = 0; i < cookies.length; i++){
                String name = URLDecoder.decode(cookies[i].getName(),"utf-8");
                String value = URLDecoder.decode(cookies[i].getValue(),"utf-8");;

                if("user".equals(name))
                {
                    userName = value;
                    out.println("found user :"+userName+"<br>");
                }

                if("AutoLogin".equals(name) && "true".equals(value))
                {
                    isAutoLogin = true;
                    if(null != userName)
                        break;
                }
            }
        }
//        这里设置的是属性,应该封装成一个方法
        if(isAutoLogin || (null != userName && !"".equals(userName)))
        {
            request.setAttribute("user", userName);
            request.getRequestDispatcher("/Test/AutoLoginDemo/WelcomeFrame.jsp")
                   .forward(request, response);

        }
        else
        {

//            out.println(printCookies(request.getCookies()));
        }
    %>
    <%--/Test/AutoLoginDemo/WelcomeFrame.jsp--%>
    <form action = "/Test/AutoLoginDemo/WelcomeFrame.jsp", method = "post">
        <%
            out.println("你的名字：");
        %>
        <input type = "text" name = "user">
        <br>
        <%
            out.println("自动登录：");
        %>
        <input type = "checkbox" name = "AutoLogin" value = "true">
        <br>
        <input type = "submit" value = "submit">
    </form>
</body>
</html>
