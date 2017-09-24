<%@ page import="java.io.File" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGImageEncoder" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGCodec" %>
<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/8/4
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DynamicPasswd</title>
</head>
<body>
    <%
       int width = 120;
       int height = 40;
       BufferedImage imgBuf = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
       Graphics2D g = imgBuf.createGraphics();
       g.setBackground(Color.white);
       g.drawImage(null, 0,0,width, height, null);
       Font font = new Font("华文楷体", 30,30);
       g.setColor(Color.white);
       g.drawString("8808", 10, 20);
       g.dispose();
       imgBuf.flush();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
        encoder.encode(imgBuf);

    %>
</body>
</html>
