<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-01-11
  Time: 오전 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Member List</title>
    </head>
    <body>
        <table border="1">
            <tr>
        <c:forEach var="i" begin="0" end="${mList.size()-1}" step="1" >
            <td>
                ${mList.get(i).getIdx()}
            </td>
            <td>
                ${mList.get(i).getId()}
            </td>
            <td>
                ${mList.get(i).getName()}
            </td>
            <td>
                ${mList.get(i).getPassword()}
            </td>
            <tr>
        </c:forEach>
        </table>
    </body>
</html>
