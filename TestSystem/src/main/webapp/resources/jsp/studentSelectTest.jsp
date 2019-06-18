<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><locale:message code="title.name"/></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
</head>
<body>
<c:if test="${selectSubject.equalsIgnoreCase('true')}">
    <c:choose>
        <c:when test="${subjects.size() > 0}">
            <form action="/student/takeTestList" method="post">
                <h2><label for="availableSubjects"><locale:message code="label.availableTests"/></label></h2>
                <select id="availableSubjects" name="selectedSubject">
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="<locale:message code="button.look4Tests"/> "/>
            </form>
        </c:when>
        <c:otherwise>
            <div class="message">
                <p style="color: #00ff00;"><locale:message code="label.noAvailableSubjects"/> </p>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>
<c:if test="${selectTest.equalsIgnoreCase('true')}">
    <c:choose>
        <c:when test="${tests.size() > 0}">
            <form action="/student/takeTest" method="post">
                <h2><label for="availableTests"><locale:message code="label.availableTests"/></label></h2>
                <p><locale:message code="label.selectedSubject"/>:${tests.get(0).subject.name} </p>
                <select id="availableTests" name="selectedTest">
                    <c:forEach items="${tests}" var="test">
                        <option value="${test.id}">${test.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="<locale:message code="button.nameStartTest"/> "/>
            </form>
        </c:when>
        <c:otherwise>
            <div class="message">
                <form>
                    <p style="color: #00ff00;"><locale:message code="label.NoAvailableTests"/></p>
                </form>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>
