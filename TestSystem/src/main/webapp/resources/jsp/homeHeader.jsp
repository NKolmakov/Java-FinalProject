<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><locale:message code="title.name"/></title>
</head>
<body>
<h2>
    <c:if test="${user.role.equalsIgnoreCase('student')}">
        <a href="/student"><img id="accountIcon" src="/resources/images/student1.png"></a>
    </c:if>
    <c:if test="${user.role.equalsIgnoreCase('tutor')}">
        <a href="/tutor"><img id="accountIcon" src="/resources/images/teacher1.png"></a>
    </c:if>
    <div id="header-caption">${user.firstName} ${user.lastName}</div>
    <div id="header-role">${user.role}</div>
</h2>
</body>
</html>
