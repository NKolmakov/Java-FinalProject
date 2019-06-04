<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>MyTitle</title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/js/script.js"/>"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <meta charset="UTF-8">
</head>

<body>
<div class="form-style-8">
    <h2>Login to your account</h2>
    <form action="login" method="post">
        <input type="text" id="firstName" name="firstName" placeholder="first name"/>
        <input type="text" id="lastName" name="lastName" placeholder="last name"/>
        <input type="text" id="groupName" name="groupName" placeholder="group"/>
        <input type="submit" value="send"/>
    </form>
</div>
</body>

</html>