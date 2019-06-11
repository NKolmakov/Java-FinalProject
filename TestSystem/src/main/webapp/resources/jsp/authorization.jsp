<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title><locale:message code="title.name"/></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/js/script.js"/>"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <meta charset="UTF-8">
</head>

<body>
<div class="form-style-8">
    <div>
        <h2><locale:message code="formAuth.name"/></h2>
        <div class="lang">
            <a href="${pageContext.request.contextPath}?lang=en">EN</a>
            <a href="${pageContext.request.contextPath}?lang=ru">RU</a>
        </div>
    </div>
    <div>
        <form action="signIn" method="post">
            <input type="text" id="login" name="login" placeholder="<locale:message code="label.login"/>"/>
            <input type="password" id="password" name="password" placeholder="<locale:message code="label.password"/>"/>
            <input type="submit" value="<locale:message code="button.enter"/>"/>
        </form>
    </div>
    <p><locale:message code="label.haveNotAccount"/><a href="registration"><locale:message code="label.signUp"/></a></p>
</div>
</body>

</html>