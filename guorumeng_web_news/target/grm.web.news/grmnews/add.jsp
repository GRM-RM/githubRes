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
    <title>添加新闻</title>
    <link href="/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/kindeditor-all-min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/lang/zh_CN.js"></script>
</head>

<body>
<h1>添加新闻</h1>
<form action="/grmNews/do_addNews.html" method="post" id="newsForm" >
    <div style="line-height:2;">
        新闻分类:<select name="grmCategory.id">
        <c:forEach items="${list}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select><br>
        作者:<input type="text" name="author"><br>
        标题:<input type="text" name="title"><br>
        内容:<br>
        <textarea required="required" style="width:800px;height:300px;visibility:hidden;" name="content" id="editor"></textarea>
        <input type="button" value="提交" onclick="doAdd()">
    </div>
</form>

</body>

<script type="text/javascript" >
    function doAdd() {
        editor.sync();//同步富文本编辑器到textarea
        $("#newsForm").submit();
    }

    var kingEditorParams ={
        filePostName  : "file",//指定上传文件参数名称
        uploadJson:'/grmNews/upload.html',//指定上传文件请求的url。
        dir:"image"//上传类型，分别为image、flash、media、file
    }

    var editor;
    $(function () {
        editor=KindEditor.create($("#editor"),kingEditorParams);
    })
</script>

</html>
