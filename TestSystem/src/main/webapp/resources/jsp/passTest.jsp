<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello !</title>
    <script src="<c:url value="/resources/js/script.js"/>"></script>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="home-page">
    <jsp:include page="homeHeader.jsp"/>
</div>
<div class="test">
    <form action="/passTest" method="post" modelAttribute="answerLogForm">
        <input hidden name="testId" value="${test.id}">
        <c:forEach items="${test.questions}" var="question" varStatus="qInc">
            <div class="question">
                <input hidden value="${counter}"/>
                <label for="${question.id}">${question.text}</label><br>
                <input hidden id="${question.id}">
                <c:forEach items="${question.answers}" var="answer" varStatus="status">
                    <c:choose>
                        <c:when test="${!question.manyRightAnswers}">
                            <input hidden value="${status.count}">
                            <input hidden name="answers[${counter}].questionId" value="${question.id}">
                            <input hidden name="answers[${counter}].answerId" value="${answer.answerId}">
                            <input hidden name="answers[${counter}].right" value="${answer.right}"/>
                            <input type="radio" class="answers" id="${answer.answerId}" name="answers[${counter}].checked">
                            <label class="answers" for="${answer.answerId}">${answer.answerText}</label><br>
                            <input hidden value="${counter = counter+1}"/>
                        </c:when>
                        <c:otherwise>
                            <input hidden value="${status.count}">
                            <input hidden name="answers[${counter}].questionId" value="${question.id}"/>
                            <input hidden name="answers[${counter}].answerId" value="${answer.answerId}"/>
                            <input hidden name="answers[${counter}].right" value="${answer.right}"/>
                            <input type="checkbox" class="answers" id="${answer.answerId}" name="answers[${counter}].checked"/>
                            <label class="answers" for="${answer.answerId}">${answer.answerText}</label><br>
                            <input hidden value="${counter = counter+1}"/>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
            <hr>
        </c:forEach>
        <input type="submit" value="Send test"/>
    </form>
</div>
<footer>
    © 2019 Kolmakov Nikita. All rights reserved.
</footer>
</body>
</html>