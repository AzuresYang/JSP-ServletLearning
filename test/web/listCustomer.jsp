<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/9/19
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CustomerList</title>
</head>
<body>
    <h3 align="center">客户列表</h3>
    <table border="1" width="70%" align="center">
        <tr>
            <th>客户姓名</th>
            <th>性别</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pb.beanList}" var="cstm">
            <tr>
                <td>${cstm.name}</td>
                <td>${cstm.gender}</td>
                <td>${cstm.phone}</td>
                <td>${cstm.email}</td>
                <td>${cstm.description}</td>
                <td>
                    <a href="<c:url value='index.jsp?method=preEdit&id=${cstm.id}'/>">编辑</a>
                    <a href="<c:url value='index.jsp?t?method=delete&id=${cstm.id}'/>">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

<br/>
<center>
    第${pb.currentPageCode}页/共${pb.totalPage}页
    <a href = "${pb.url}&pc=1">首页</a>
    <a href = "${pb.url}&pc=${pb.totalPage}">尾页</a>
    <c:if test = "${pb.currentPageCode} > 1">
        <a href =  "${pb.url}&pc=${pb.currentPageCode-1}">上一页</a>
    </c:if>
    <c:if test = "${pb.currentPageCode} <  ${pb.totalPage} ">
        <a href =  "${pb.url}&pc=${pb.currentPageCode+1}">下一页</a>
    </c:if>

    <c:choose>
         <c:when test = "${pb.totalPage} <10">
             <c:set var = "beginPage" value = "1"/>
             <c:set var = "endPage" value = "${pb.totalPage}"/>
         </c:when>
        <c:otherwise>
            <c:set var = "beginPage" value = "${pb.currentPageCode-5}"/>
            <c:set var = "endPage" value = "${pb.totalPage-4}"/>
            <!--处理头溢出-->
            <c:if test = "${beginPage<1}">
                <c:set var = "beginPage" value = "1"/>
            </c:if>
            <!--处理尾溢出-->
            <c:if test = "${endPage > pb.totalPage}">
                <c:set var = "endPage" value = "${pb.totalPage}"/>
            </c:if>
        </c:otherwise>
    </c:choose>

    <!--循环遍历页码表-->

    <c:forEach var="i" begin="${beginPage}" end="${endPage}">
        <a href="${pb.url}&pc=${i}">[${i}]</a>
    </c:forEach>

</center>


</body>
</html>
