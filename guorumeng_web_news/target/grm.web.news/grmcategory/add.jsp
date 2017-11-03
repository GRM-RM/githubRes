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
    <title>添加新闻分类</title>
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
</head>

<body>
<form action="/grmCategory/addGrmCategory.html" method="post">
    新闻类别<input type="text" name="name"> <br>
    <input type="submit" name="添加">
    <input type="button" value="取消" onclick="ret()">
</form>

<script type="text/javascript">
    function ret() {
        window.location.href="/grmCategory/findAll.html";
    }
</script>

</body>

</html>
