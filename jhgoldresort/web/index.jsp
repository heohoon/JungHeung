<%--
  Created by IntelliJ IDEA.
  User: heohoon
  Date: 2020/01/10
  Time: 10:39 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index Page</title>
  </head>
  <body>
    <form action="login.jh" method="POST">
      <label>ID :</label>
      <input type="text" name="userId" placeholder="input your ID">
      <label>Password :</label>
      <input type="password" name="userPassword" placeholder="input your password">
      <input type="submit" name="submit" value="LogIn">
    </form>
  </body>
</html>
