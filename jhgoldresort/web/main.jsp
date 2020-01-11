<%--
  Created by IntelliJ IDEA.
  User: heohoon
  Date: 2020/01/11
  Time: 12:36 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    ${userName}<br>
    <h3>${userName}님 환영합니다.</h3><br>
    <form action="/memberList.jh" method="POST">
        <input type="submit" name="submit" value="get all member list">
    </form>

</body>
</html>
