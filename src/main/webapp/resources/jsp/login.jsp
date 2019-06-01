<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: colma
  Date: 22.05.2019
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
    <table>
        <tr>
            <th>User Name</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.firstName}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
