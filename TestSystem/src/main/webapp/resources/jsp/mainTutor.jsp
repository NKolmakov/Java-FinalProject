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
        <li><a href="/createTest"><locale:message code="label.createTest"/> </a></li>
        <li><a href="#1"><locale:message code="label.viewPassedTests"/> </a></li>
        <li><a href="#2"><locale:message code="label.seeStatistic"/> </a></li>
    </ul>
</nav>

<main role="main">
    <div class="home-page">
        <h2>
            <img id="accountIcon" src="/resources/images/teacher1.png">
            <div id="header-caption">${user.firstName} ${user.lastName}</div>
            <div id="header-role">${user.role}</div>
        </h2>
    </div>
</main>
<footer>
    © 2019 Kolmakov Nikita. All rights reserved.
</footer>
</body>
</html>