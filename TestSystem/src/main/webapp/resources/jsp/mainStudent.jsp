<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><locale:message code="title.name"/></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="<c:url value="/resources/js/script.js"/>"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<input type="checkbox" id="nav-toggle" hidden>
<nav class="nav">
    <label for="nav-toggle" class="nav-toggle" onclick></label>
    <h2 class="logo">
        <locale:message code="label.actions"/>
    </h2>
    <ul>
        <li><a href="/student/takeSubjects"><locale:message code="label.passTest"/> </a></li>
        <li><a href="#2"><locale:message code="label.seeStatistic"/> </a></li>
    </ul>
</nav>

<main role="main">
    <div class="home-page">
        <jsp:include page="homeHeader.jsp"/>
        <jsp:include page="studentSelectTest.jsp"/>
        <jsp:include page="message.jsp"/>
<%--        <c:if test="${selectSubject.equalsIgnoreCase('true')}">--%>
<%--            <c:choose>--%>
<%--                <c:when test="${subjects.size() > 0}">--%>
<%--                    <form action="/student/takeTestList" method="post">--%>
<%--                        <h2><label for="availableSubjects"><locale:message code="label.availableTests"/></label></h2>--%>
<%--                        <select id="availableSubjects" name="selectedSubject">--%>
<%--                            <c:forEach items="${subjects}" var="subject">--%>
<%--                                <option value="${subject.id}">${subject.name}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                        <input type="submit" value="<locale:message code="button.look4Tests"/> "/>--%>
<%--                    </form>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <div class="message">--%>
<%--                        <p style="color: #00ff00;"><locale:message code="label.noAvailableSubjects"/> </p>--%>
<%--                    </div>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </c:if>--%>
<%--        <c:if test="${selectTest.equalsIgnoreCase('true')}">--%>
<%--            <c:choose>--%>
<%--                <c:when test="${tests.size() > 0}">--%>
<%--                    <form action="/student/takeTest" method="post">--%>
<%--                        <h2><label for="availableTests"><locale:message code="label.availableTests"/></label></h2>--%>
<%--                        <p><locale:message code="label.selectedSubject"/>:${tests.get(0).subject.name} </p>--%>
<%--                        <select id="availableTests" name="selectedTest">--%>
<%--                            <c:forEach items="${tests}" var="test">--%>
<%--                                <option value="${test.id}">${test.name}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                        <input type="submit" value="<locale:message code="button.nameStartTest"/> "/>--%>
<%--                    </form>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <div class="message">--%>
<%--                        <form>--%>
<%--                            <p style="color: #00ff00;"><locale:message code="label.NoAvailableTests"/></p>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </c:if>--%>
        <%--    message about successful saved test    --%>
<%--        <c:choose>--%>
<%--            <c:when test="${testSaved.equalsIgnoreCase('true')}">--%>
<%--                <div class="message">--%>
<%--                    <form>--%>
<%--                        <p style="color: #00ff00;"><locale:message code="label.testSaved"/></p>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </c:when>--%>
<%--            <c:when test="${testSaved.equalsIgnoreCase('false')}">--%>
<%--                <div class="message">--%>
<%--                    <form>--%>
<%--                        <p style="color: #ff0000;"><locale:message code="label.testNotSaved"/></p>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </c:when>--%>
<%--        </c:choose>--%>
    </div
</main>
<footer>
    © 2019 Kolmakov Nikita. All rights reserved.
</footer>
</body>
</html>
