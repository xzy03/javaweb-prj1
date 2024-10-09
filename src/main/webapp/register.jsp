<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2024/9/25
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通用户注册</title>
</head>
<body>
<script type="text/javascript">
    function check()
    {
        var username=document.getElementById("username");
        var password=document.getElementById("password");
        if(username.value.length>6||password.value.length>6)
        {alert("用户名和密码不得超过 6 位！"); return false;}
        else if(username.value==""||password.value=="")
        {alert("用户名和密码不得为空"); return false;}
        else return true;
    }
</script>
<form action="login" method="post" onsubmit="return check()">
    <input type="hidden" name="source" value="register">
    <table>
        <tr><td>请输入用户名：</td><td><input name="username" id="username" type="text"></td></tr>
        <tr><td>请输入密码：</td><td><input name="password" id="password" type="password"></td></tr>
        <tr><td>请选择用户类型：</td><td>
            <select name="usertype">
                <option value="普通用户">普通用户</option>
                <option value="管理员">管理员</option>
            </select>
        </td></tr>
        <tr><td><input type="submit" value="注册"></td></tr>
    </table>
</form>
</body>
</html>
