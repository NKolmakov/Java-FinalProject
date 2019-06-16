<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><locale:message code="title.name"/></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
</head>
<body>

<input type="checkbox" id="nav-toggle" hidden>
<nav class="nav">
    <label for="nav-toggle" class="nav-toggle" onclick></label>
    <h2 class="logo">
        <locale:message code="label.actions"/>
    </h2>
    <ul>
        <li><a href="/createTest"><locale:message code="label.createTest"/> </a></li>
        <li><a href="#1"><locale:message code="label.viewPassedTests"/> </a></li>
        <li><a href="#2"><locale:message code="label.seeStatistic"/> </a></li>
    </ul>
</nav>

<main role="main">
    <div class="home-page">
        <jsp:include page="homeHeader.jsp"/>
    </div>
    <form:form action="/saveTest" method="post" modelAttribute="createTestForm">
        <div class="test">
            <input hidden id="button.addAnswer" value="<locale:message code="button.addAnswer"/> "/>
            <input type="button" id="createQuestion" value="<locale:message code="button.createQuestion"/> ">
            <input type="submit" id="saveTest" value="<locale:message code="button.saveTest"/>"/>
            <div class="questionBlock">
            </div>
        </div>
    </form:form>
</main>
<footer>
    © 2019 Kolmakov Nikita. All rights reserved.
</footer>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/script.js"/>"></script>
</body>
</html>