<%--
  Created by IntelliJ IDEA.
  User: 28029
  Date: 2017/9/11
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理系统</title>
</head>
<body>
<h3 align = "center">添加客户</h3>
<form action = "CustomerServlet" method = "post">
    <input type = "hidden" name="method" value="add">
    <table border="0" align="center" style="margin-left:100px">
        <tr>
            <td width="100px">客户名称</td>
            <td width="40%">
                <input type="text" name="name" value="TestCus">
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>

        <tr>
            <td>客户性别</td>
            <td>
                <input type="radio" checked="checked"  name="gender" value="male" id="male"/>
                <label for="male">男</label>
                <input type="radio" name="gender" value="female" id="female"/>
                <label for="female">女</label>
            </td>
            <td>
                <label id="genderError" class="error">&nbsp;</label>
            </td>
        </tr>

        <tr>
            <td>手机</td>
            <td>
                <input type="text" name="phone" value = "15113536680"id="phone">
            </td>
            <td>
                <label id="phoneError" class="error">&nbsp;</label>
            </td>
        </tr>

        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="emial" value = "1@qq.com" id="emial">
            </td>
            <td>
                <label id="emialError" class="error">&nbsp;</label>
            </td>
        </tr>

        <tr>
            <td>描述</td>
            <td>
                <textarea rows="5" cols="30" value = "TestDesc" name="description"></textarea>
            </td>

            <td>
                <label id="textareaError" class="error">&nbsp;</label>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit"/>
                <input type="reset" name="reset"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
