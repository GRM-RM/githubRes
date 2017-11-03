<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <title></title>

</head>

<body>
<form action="/grmUser/do_login.html" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td>
                <input type="text" name="username" required="required" value="${param.username}">

            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <input type="password" name="password" required="required">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录" >
                <span style="color: red">${msg}</span>
            </td>
        </tr>
    </table>
</form>
<a href="/grmuser/register.jsp">去注册</a>
</body>

</html>
