<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2024/9/25
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="cn.edu.zjut.model.UserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="USER" class="cn.edu.zjut.model.UserBean" scope="request"/>
<html>
<head>
    <title>登陆成功</title>

</head>
<body>
登录成功,欢迎您,<%=USER.getUsername() %>
</body>
</html>
