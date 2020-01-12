<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-01-12
  Time: 오전 10:55
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
            <input type="text" name="userId" placeholder="input your ID">
            <label>Password :</label>
            <input type="password" name="userPassword" placeholder="input your password">
            <label>Name :</label>
            <input type="text" name="userName" placeholder="input your name">
            <input type="submit" name="submit" value="join">
        </form>
    </body>
</html>
