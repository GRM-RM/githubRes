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

<c:choose>
    <c:when test="${empty sessionScope.grmUser}">
        <a href="/grmuser/register.jsp">注册</a>
        <a href="/grmuser/login.jsp">登录</a>
    </c:when>
    <c:otherwise>
        欢迎:${sessionScope.grmUser.username}<a href="/grmUser/logout.html">退出登陆</a><br>
        <a href="/grmNews/findGrmNews.html">新闻列表</a><br>
        <a href="/grmCategory/findAll.html">分类列表</a>
    </c:otherwise>
</c:choose>
</body>

</html>