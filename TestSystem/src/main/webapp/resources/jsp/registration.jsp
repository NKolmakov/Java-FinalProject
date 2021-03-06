<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title><locale:message code="title.name"/></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script src="<c:url value="/resources/js/script.js"/>"></script>
    <meta charset="UTF-8">
</head>

<body>
<div class="form-style-8">
    <div>
        <h2><locale:message code="formReg.name"/></h2>
        <div class="lang">
            <a href="${pageContext.request.contextPath}?lang=en"><img alt="en" id="en" src="<c:url value="/resources/images/eng.png"/>"></a>
            <a href="${pageContext.request.contextPath}?lang=ru"><img alt="ru" id="ru" src="<c:url value="/resources/images/rus.jpg"/>"></a>
        </div>
    </div>
    <div>
        <form action="signUp" method="post">
            <c:if test="${error.equalsIgnoreCase('true')}">
                <div>
                    <p style="color: #ff0000; font-size: 18px;"><locale:message code="label.registrationFailed"/> </p>
                </div>
            </c:if>
            <c:if test="${error.equalsIgnoreCase('false')}">
                <div>
                    <p style="color: #00ff00; font-size: 18px;"><locale:message code="label.registrationSuccess"/> </p>
                </div>
            </c:if>
            <input type="text" id="firstName" name="firstName" placeholder="<locale:message code="label.firstName"/>" required/>
            <input type="text" id="lastName" name="lastName" placeholder="<locale:message code="label.lastName"/>" required/>
            <input type="text" id="login" name="login" placeholder="<locale:message code="label.login"/>" required/>
            <input type="password" id="password" name="password" placeholder="<locale:message code="label.password"/>" required>
            <select name="groupId">
                <c:forEach items="${groups}" var="group">
                    <option name="${group.id}" value="${group.id}">${group.groupName}</option>
                </c:forEach>
            </select>
            <input type="submit" value="<locale:message code="button.name"/>"/>
        </form>
    </div>
    <p><locale:message code="label.hasAccount"/><a href="authorization"><locale:message code="label.logIn"/></a></p>
</div>
</body>
</html>