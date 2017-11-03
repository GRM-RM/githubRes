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
    <title>新闻分类列表</title>

</head>

<body>
    <a href="/grmcategory/add.jsp">添加分类</a>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>分类</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td><a href="/grmCategory/del.html?name=${category.name}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>
