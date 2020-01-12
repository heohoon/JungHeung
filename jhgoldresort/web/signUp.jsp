<%--
  Created by IntelliJ IDEA.
  User: heohoon
  Date: 2020/01/11
  Time: 10:51 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp Page</title>
</head>
<body>
    <form action="/join.jh" method="POST">
        <label>ID :</label>
        <input type="text" name="userId">
        <label>Password :</label>
        <input type="text" name="userPassword">
        <label>Name :</label>
        <input type="text" name="userName">
        <input type="submit" name="submit" value="Join">
    </form>
</body>
</html>
