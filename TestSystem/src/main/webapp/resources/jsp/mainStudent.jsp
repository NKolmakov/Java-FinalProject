<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><locale:message code="title.name"/></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="<c:url value="/resources/js/script.js"/>"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>

<input type="checkbox" id="nav-toggle" hidden>
<nav class="nav">
    <label for="nav-toggle" class="nav-toggle" onclick></label>
    <h2 class="logo">
        <locale:message code="label.actions"/>
    </h2>
    <ul>
        <li><a href="/selectTest"><locale:message code="label.passTest"/> </a></li>
        <li><a href="#2"><locale:message code="label.seeStatistic"/> </a></li>
    </ul>
</nav>

<main role="main">
    <div class="home-page">
        <h2>${user.firstName} ${user.lastName}</h2>
<%--        code to show form with test list--%>
        <c:if test="${passTest.equalsIgnoreCase('true')}">
            <c:choose>
                <c:when test="${tests.size() > 0}">
                    <form action="/passTest" method="post" >
                        <h2><label for="availableTests"><locale:message code="label.availableTests"/></label></h2>
                        <select id="availableTests" name="selectedTest">
                            <c:forEach items="${tests}" var="test">
                                <option value="${test.id}">${test.name}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="<locale:message code="button.nameStartTest"/> "/>
                    </form>
                </c:when>
                <c:otherwise>
                    <p><locale:message code="label.NoAvailableTests"/></p>
                </c:otherwise>
            </c:choose>
        </c:if>
    </div>
    <footer>
        © 2019 Kolmakov Nikita. All rights reserved.
    </footer>
</main>
</body>
</html>
