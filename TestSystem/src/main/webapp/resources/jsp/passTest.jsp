<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>
<div class="home-page">
    <jsp:include page="homeHeader.jsp"/>
</div>
<div class="test">
    <form action="/student/passTest" method="post" name="answerLogForm" modelAttribute="answerLogForm">
        <input hidden name="testId" value="${test.id}">
        <c:forEach items="${test.questions}" var="question">
            <div class="question">
                <input hidden value="${counter = counter+1}"/>
                <h4> ${question.text}</h4><br>
<%--                <input hidden id="${question.id}">--%>
                <c:forEach items="${question.answers}" var="answer" varStatus="status">
                    <c:if test="${question.manyRightAnswers}">
                        <div>
                            <input hidden value="${status.count}">
                            <input hidden name="answers[${counter}].questionId" value="${question.id}">
                            <input hidden name="answers[${counter}].answerId" value="${answer.answerId}">
                            <input hidden name="answers[${counter}].right" value="${answer.right}"/>
                            <input type="checkbox" id="check_${answer.answerId}" class="answerCheckbox"
                                   name="answers[${counter}].selected">${answer.answerText}<br>
                            <c:if test="${!status.last}">
                                <input hidden value="${counter = counter+1}"/>
                            </c:if>
                        </div>
                    </c:if>
                    <c:if test="${!question.manyRightAnswers}">
                        <div>
                            <input hidden value="${status.count}">
                            <input hidden name="answers[${counter}].questionId" value="${question.id}"/>
                            <input hidden name="answers[${counter}].answerId" value="${answer.answerId}"/>
                            <input hidden name="answers[${counter}].right" value="${answer.right}"/>
                            <input hidden id="answ_${answer.answerId}" name="answers[${counter}].selected" value =""/>
                            <input id="radio_${answer.answerId}" type="radio" class="answerRadio"
                                   name="answers_id[${counter}]" value="${question.id}"/>${answer.answerText}<br>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <hr>
        </c:forEach>
        <input type="submit" value="<locale:message code="button.saveTest"/> ">
    </form>
</div>
<footer>
    © 2019 Kolmakov Nikita. All rights reserved.
</footer>
</body>
</html>