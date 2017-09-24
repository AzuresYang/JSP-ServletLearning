<%@ page import="java.util.Enumeration" %>
<%@ page import="java.net.URLEncoder" %>
<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/8/5
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("gb2312");
%>
<html>
<head>
    <title>Wecome</title>
</head>
<%!
    String printAttribute(Enumeration<String>  attrs, HttpServletRequest request){
        String result = "<br>显示属性：<br>";
        if(null != attrs)
        while(attrs.hasMoreElements()){
            String next = attrs.nextElement();
            result += "key:"+ next +"value:"+ request.getAttribute(next)+"<br>";
        }
        return result;
    }
%>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String autoLogin = request.getParameter("AutoLogin");
    if(null != autoLogin && "true".equals(autoLogin))
    {
        //这里应该封装成一个方法。
        String strKey =  URLEncoder.encode("AutoLogin","UTF-8");
        String  strValue= URLEncoder.encode("true","UTF-8");
        Cookie cookie = new Cookie(strKey,strValue);
        cookie.setMaxAge(3);
        response.addCookie(cookie);
//        new String(request.getParameter("user").getBytes("utf-8"),"gb2312")
        strKey =  URLEncoder.encode("user","UTF-8");
        strValue= URLEncoder.encode(request.getParameter("user"),"UTF-8");
        Cookie cookie2 = new Cookie(strKey, strValue);
        cookie2.setMaxAge(3);
        response.addCookie(cookie2);
    }
%>
    <%
        String name = request.getParameter("user");
        if(null == name || "".equals(name))
        {
            name = (String)request.getAttribute("user");
            if(null == name || "".equals(name))
            {
//               out.println(printAttribute(request.getAttributeNames(), request));
                name = "无名";
            }

        }
//        out.println(printAttribute(request.getAttributeNames(), request));
    %>

    <h1 style = "text-align:center;color:deepskyblue;font-size:50px">
      嘟嘟噜~~~~
    </h1>

    <p>
        ${param["aa"]}
    </p>
    <pre><img src="/resources/Gate of steiner01.jpg" align ="left"></pre>
    <p style = "text-align:left;color:darkturquoise;font-size:30px">
         <%out.println("欢迎访问："+name);%>
        <%--<%out.println("<br>user属性为："+request.getAttribute("user"));%>--%>
    </p>
    <p>
        <a href = "/Test/AutoLoginDemo/LoginFrame.jsp">返回上一页</a>
    </p>
</body>
</html>


