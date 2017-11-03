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
    <title>新闻列表</title>
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
</head>

<body>
<h1>新闻列表</h1>
<a href="/grmNews/addGrmNews.html">添加新闻</a>


<form action="/grmNews/findGrmNews.html" id="searchForm" method="post">
    <div style="line-height: 30px">
        <input hidden type="text" name="pageIndex" value="1" id="pageIndex"/>
        分类:<select name="grmCategory.name">
                <option value="" >请选择</option>
                <c:forEach items="${categoryList}" var="cl">
                    <option value="${cl.name}" ${cl.name==grmNewsUtil.grmCategory.name?"selected":""}>${cl.name}</option>
                </c:forEach>
            </select><br>
        作者:<input type="text" name="author" value="${grmNewsUtil.author}"><br>
        标题:<input type="text" name="title" value="${grmNewsUtil.title}"><br>
        内容:<input type="text" name="content" value="${grmNewsUtil.content}"><br>
        起始时间:<input type="date" name="startTime" value="<fmt:formatDate value="${grmNewsUtil.startTime}" pattern="yyyy-MM-dd"/>">
        -结束时间:<input type="date" name="endTime" value="<fmt:formatDate value="${grmNewsUtil.endTime}" pattern="yyyy-MM-dd"/>"><br>
        <input type="button" value="搜索" onclick="search()">
    </div>
</form>
<table border="1">
    <tr>
        <td>新闻标题</td>
        <td>新闻作者</td>
        <td>发布时间</td>
    </tr>
    <c:forEach items="${page.list}" var="grmNews">
        <tr>
            <td><a href="/grmNews/findById.html?id=${grmNews.id}">${grmNews.title}</a></td>
            <td>${grmNews.author}</td>
            <td><fmt:formatDate value="${grmNews.createdDate}" pattern="yyyy-MM-dd HH:mm"/> </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${page.pages>1}">

        <c:if test="${page.hasPreviousPage}">
            <a href="javascript:search('${page.prePage}')">上一页</a>
        </c:if>

        <c:forEach items="${page.navigatepageNums}" var="np">
            <c:choose>
                <c:when test="${page.pageNum==np}">
                    <a style="font-size: 20px" href="javascript:search('${np}')">${np}</a>
                </c:when>
                <c:otherwise>
                    <a href="javascript:search('${np}')">${np}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${page.hasNextPage}">
            <a href="javascript:search('${page.nextPage}')">下一页</a>
        </c:if>
        <input type="number" style="width: 30px" id="num">
        <input type="button" value="前往" onclick="go()">

</c:if>
<script type="text/javascript">
    function go() {
        var num=$("#num").val();
        if(num==null||num.trim()==""){
            alert("请输入要前往的页码");
            return;
        }
        search(num);
    }
</script>
</body>
<script type="text/javascript">
    function search() {
        $("#searchForm").submit();
    }

    function search(obj) {
        $("#pageIndex").val(obj);
        $("#searchForm").submit();
    }
</script>
</html>
