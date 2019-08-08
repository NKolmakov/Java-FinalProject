<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
<c:choose>
    <c:when test="${testSaved.equalsIgnoreCase('true')}">
        <div class="message">
            <form>
                <p style="color: #00ff00;"><locale:message code="label.testSaved"/></p>
                <p><locale:message code="label.rightQuestionsAmount"/> ${rightQuestions} <locale:message code="label.from"/> ${commonQuestions} </p>
            </form>
        </div>
    </c:when>
    <c:when test="${testSaved.equalsIgnoreCase('false')}">
        <div class="message">
            <form>
                <p style="color: #ff0000;"><locale:message code="label.testNotSaved"/></p>
            </form>
        </div>
    </c:when>
    <c:when test="${save.equalsIgnoreCase('true')}">
        <div class="message">
            <form>
                <p style="color: #00ff00;"><locale:message code="message.savedSuccessfully"/></p>
            </form>
        </div>
    </c:when>
    <c:when test="${save.equalsIgnoreCase('false')}">
        <form>
            <p style="color: #ff0000;"><locale:message code="message.errorSave"/></p>
        </form>
    </c:when>
</c:choose>
</body>
</html>
