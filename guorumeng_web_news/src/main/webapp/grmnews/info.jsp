<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <title>新闻详情</title>

</head>

<body>
    <h2>新闻详情</h2>

    <h1>${grmNews.title}</h1>
    <h3>${grmNews.author}</h3>
    <h3><fmt:formatDate value="${grmNews.createdDate}" pattern="yyyy-MM-dd HH:mm" /></h3>
<hr>
<div>
    ${grmNews.content}
</div>
</body>

</html>
