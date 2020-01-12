<%--
  Created by IntelliJ IDEA.
  User: heohoon
  Date: 2020/01/11
  Time: 12:36 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <c:if test="${not empty userName}">
    ${userName}<br>
    <h3>${userName}님 환영합니다.</h3><br>
    <form action="/memberList.jh" method="POST">
        <input type="submit" name="submit" value="get all member list">
    </form>
    </c:if>
    <h1>This is Main page</h1>
    <input type="button" onclick="location.href='/'" name="button" value="HOME">
</body>
</html>
