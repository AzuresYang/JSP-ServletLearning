<%@ page import="java.io.File" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGImageEncoder" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGCodec" %>
<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/8/4
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GengertateDynamicImg</title>
</head>
<body>
    <%
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        File imgFile = new File("F:\\saber02.jpg");

        Image src = javax.imageio.ImageIO.read(imgFile);

        int width = src.getWidth(null);
        int height = src.getHeight(null);

        BufferedImage imgBuf = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        Graphics g = imgBuf.createGraphics();
        g.drawImage(src, 0,0,width, height, null);

        String drawStr = request.getParameter("drawStr");
        if(drawStr == null || drawStr== "")
            drawStr = "no drawStr";

        g.setColor(Color.black);

        int drawY = 30;
        int centerX = width /2 - drawStr.length()/2;
        centerX = centerX > 0 ? centerX: 0;

        g.drawString(drawStr, centerX, drawY);

        g.dispose();
        imgBuf.flush();

        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
        encoder.encode(imgBuf);

    %>
</body>
</html>
