<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="test">
    <form action="/takeTest" method="post" modelAttribute="answerLogForm">
        <c:forEach items="${questions}" var="question" varStatus="status">
            <div class="question">
                <input hidden value="${status.count}">
                <input hidden name="questions[${status.index}].id" value="${question.id}">
                <label for="${question.id}">${question.text}</label><br>
                <input hidden id="${question.id}" name="questions[${status.index}].text" value="${question.text}">
                <c:forEach items="${question.answers}" var="answer">
                    <input hidden name="answers[${status.index}].questionId" value="${question.id}">
                    <input class="answer" id="${answer.answerId}" type="radio" name="answers[${status.index}].answerId"
                           value="${answer.answerId}">
                    <label class="answer" for="${answer.answerId}">${answer.answerText}</label><br>
                </c:forEach>
            </div>
            <hr>
        </c:forEach>
        <input type="submit" value="Send test"/>
    </form>
</div>
</body>
</html>
--%>
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
    <h2>
        <img id="accountIcon" src="teacher.png">
        ${user.firstName} ${user.lastName}
        <label>role</label>
    </h2>
</div>
<div class="test">
    <form action="/passTest" method="post" modelAttribute="answerLogForm">
        <input hidden name="testId" value="${test.id}">
        <c:forEach items="${test.questions}" var="question" varStatus="status">
            <div class="question">
                <input hidden value="${status.count}">
                <input hidden name="questions[${status.index}].id" value="${question.id}">
                <label for="${question.id}">${question.text}</label><br>
                <input hidden id="${question.id}" name="questions[${status.index}].text" value="${question.text}">
                <c:forEach items="${question.answers}" var="answer">
                    <input hidden name="answers[${status.index}].questionId" value="${question.id}">
                    <input class="answer" id="${answer.answerId}" type="radio" name="answers[${status.index}].answerId"
                           value="${answer.answerId}">
                    <label class="answer" for="${answer.answerId}">${answer.answerText}</label><br>
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