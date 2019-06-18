<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
            <input hidden id="${question.id}">
            <c:forEach items="${question.answers}" var="answer" varStatus="status">
                <c:choose>
                    <c:when test="${!question.manyRightAnswers}">
                        <div>
                        <input hidden value="${status.count}">
                        <input hidden name="answers[${counter}].questionId" value="${question.id}">
                        <input hidden name="answers[${counter}].answerId" value="${answer.answerId}">
                        <input hidden name="answers[${counter}].right" value="${answer.right}"/>
                        <input type="radio" class="answer radio" id="${answer.answerId}" name="answers[${counter}].checked">${answer.answerText}<br>
                        <input hidden value="${counter = counter+1}"/>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div>
                        <input hidden value="${status.count}">
                        <input hidden name="answers[${counter}].questionId" value="${question.id}"/>
                        <input hidden name="answers[${counter}].answerId" value="${answer.answerId}"/>
                        <input hidden name="answers[${counter}].right" value="${answer.right}"/>
                        <input type="checkbox" class="answer checkbox" id="${answer.answerId}" name="answers[${counter}].checked"/>${answer.answerText}<br>
                        <input hidden value="${counter = counter+1}"/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div><hr>
            </c:forEach>
                <%--                <c:forEach items="${question.answers}" var="answer" varStatus="status">--%>
                <%--                    <c:choose>--%>
                <%--                        <c:when test="${!question.manyRightAnswers}">--%>
                <%--&lt;%&ndash;                            <div>&ndash;%&gt;--%>
                <%--                                <input hidden name="answers[${counter}].questionId" value="${question.id}">--%>
                <%--                                <input hidden name="answers[${counter}].answerId" value="${answer.answerId}">--%>
                <%--                                <input hidden name="answers[${counter}].right" value="${answer.right}"/>--%>
                <%--                                <input hidden id="some_${counter}" name="answers[${counter}].checked" value=""/>--%>
                <%--                                <input class="answer radio" type="radio" id="${answer.answerId}"--%>
                <%--                                       name="answers[${counter}].checked" value="true"/>--%>
                <%--                            <input hidden value="${counter = counter+1}"/>--%>
                <%--&lt;%&ndash;                                <label for="${answer.answerId}">${answer.answerText}</label><br>&ndash;%&gt;--%>
                <%--&lt;%&ndash;                            </div>&ndash;%&gt;--%>
                <%--                        </c:when>--%>
                <%--                        <c:otherwise>--%>
                <%--                            <div>--%>
                <%--                                <input hidden name="answers[${counter}].questionId" value="${question.id}"/>--%>
                <%--                                <input hidden name="answers[${counter}].answerId" value="${answer.answerId}"/>--%>
                <%--                                <input hidden name="answers[${counter}].right" value="${answer.right}"/>--%>
                <%--                                <input class="answer checkbox" type="checkbox" id="${answer.answerId}"--%>
                <%--                                       name="answers[${counter}].checked"/>${answer.answerText}<br>--%>
                <%--                                <c:if test="${!status.last}">--%>
                <%--                                    <input hidden value="${counter = counter+1}"/>--%>
                <%--                                </c:if>--%>
                <%--                            </div>--%>
                <%--                        </c:otherwise>--%>
                <%--                    </c:choose>--%>
                <%--                </c:forEach>--%>
                <%--            </div>--%>
                <%--            <hr>--%>
                <%--        </c:forEach>--%>
            <input type="submit" value="Send test"/>
    </form>
</div>
<footer>
    © 2019 Kolmakov Nikita. All rights reserved.
</footer>
</body>
</html>