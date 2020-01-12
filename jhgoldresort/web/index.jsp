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
<<<<<<< HEAD
    <form action="/login.jh" method="POST">
      <label>ID :</label>
      <input type="text" name="userId" placeholder="input your ID">
      <label>Password :</label>
      <input type="password" name="userPassword" placeholder="input your password">
      <input type="submit" name="submit" value="LogIn">
    </form>
      <input type="button" onclick="location.href='signUp.jh'" value="SignUp">
=======
    <div>
      <form action="login.jh" method="POST">
        <label>ID :</label>
        <input type="text" name="userId" placeholder="input your ID">
        <label>Password :</label>
        <input type="password" name="userPassword" placeholder="input your password">
        <input type="submit" name="submit" value="LogIn">
      </form>
      <input type="button" onclick="location.href='/signup.jh'" name="signUp" value="SignUp">
    </div>
>>>>>>> fc785870d7f82d3bc8ba9e4fc066bdbfd7593d32
  </body>
</html>
