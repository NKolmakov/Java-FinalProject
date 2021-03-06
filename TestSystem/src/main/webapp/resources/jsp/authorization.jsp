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
        <h2><locale:message code="formAuth.name"/></h2>
        <div class="lang">
            <a href="${pageContext.request.contextPath}?lang=en"><img id="en" src="<c:url value="/resources/images/eng.png"/>"></a>
            <a href="${pageContext.request.contextPath}?lang=ru"><img id="ru" src="<c:url value="/resources/images/rus.jpg"/>"></a>
        </div>
    </div>
    <div>
        <form action="signIn" method="post">
            <c:if test="${error.equalsIgnoreCase('true')}">
                <div>
                    <p style="color: #ff0000; font-size: 18px;"><locale:message code="label.authorizaitonError"/></p>
                </div>
            </c:if>
            <input type="text" id="login" name="login" placeholder="<locale:message code="label.login"/>" required/>
            <input type="password" id="password" name="password" placeholder="<locale:message code="label.password"/>" required/>
            <input type="submit" value="<locale:message code="button.enter"/>"/>
        </form>
    </div>
    <p><locale:message code="label.haveNotAccount"/><a href="registration"><locale:message code="label.signUp"/></a></p>
</div>
</body>
</html>