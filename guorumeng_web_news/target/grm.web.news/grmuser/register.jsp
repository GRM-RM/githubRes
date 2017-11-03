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
    <title>注册</title>
    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>

</head>

<body>
    <form action="/grmUser/do_register.html" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td>
                    <input onblur="check()" type="text" name="username" id="username" value="${param.username}" required="required" >
                    <span id="umsg" style="color: red"></span>
                </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>
                    <input type="password" name="password" required="required">
                </td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td>
                    <input type="password" name="repassword" required="required">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="注册" id="reg" >
                    <a href="/grmuser/login.jsp">去登录</a>
                </td>
            </tr>
        </table>
    </form>
<script type="text/javascript">
    function check() {
        var v=$("#username").val();
        if(v==null||v.trim()==""){
            alert("请输入用户名");
            return;
        }
        $.ajax({
            url:"/grmUser/findByUsername.html",
            data:"username="+v,
            success:function (data) {
                if(data.status){
                    $("#umsg").html(data.result);
                    $("#reg").attr("disabled","disabled");

                }else {
                    $("#umsg").html("");
                    $("#reg").removeAttr("disabled");

                }
            }
        })
    }
</script>
</body>

</html>
