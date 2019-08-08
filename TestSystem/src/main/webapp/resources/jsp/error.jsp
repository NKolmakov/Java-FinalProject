<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="error">
    <img alt="sad_smile" src="<c:url value="/resources/images/sad_smile.png"/>">
    <h1><locale:message code="label.errorMessage"/></h1>
    <c:choose>
        <c:when test="${user.role.equalsIgnoreCase('student')}">
            <h3><a href="/student/mainStudent"><locale:message code="label.backToMain"/></a></h3>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${user.role.equalsIgnoreCase('tutor')}">
                    <h3><a href="/tutor/mainTutor"><locale:message code="label.backToMain"/></a></h3>
                </c:when>
                <c:otherwise>
                    <h3><a href="/authorization"><locale:message code="label.backToMain"/></a></h3>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
