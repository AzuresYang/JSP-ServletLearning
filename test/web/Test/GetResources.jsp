<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.OutputStream" %><%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/8/4
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="img;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetSource</title>
</head>
<body>
    <%
        InputStream in = new FileInputStream("/web/WEB_INF/img01.jpg");
        OutputStream ot = response.getOutputStream();

        byte[] buffer = new byte[1024];
        int lenght =-1;
        while((lenght = in.read(buffer)) != -1)
            ot.write(buffer, 0, lenght);

        in.close();
        ot.close();
    %>>
</body>
</html>
