<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><locale:message code="title.name"/></title>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>
<h2>
    <c:if test="${user.role.equalsIgnoreCase('student')}">
        <a href="/student/mainStudent"><img id="accountIcon" src="<c:url value="/resources/images/student.png"/>"></a>
    </c:if>
    <c:if test="${user.role.equalsIgnoreCase('tutor')}">
        <a href="/tutor/mainTutor"><img id="accountIcon" src="<c:url value="/resources/images/teacher.png"/>"></a>
    </c:if>
    <div id="header-caption">${user.firstName} ${user.lastName}</div>
    <div id="header-role">${user.role}</div>
    <div id="dd" class="settings" tabindex="1"><img src="<c:url value="/resources/images/setting.png"/> ">
        <ul class="dropdown">
            <li><a href="/exit"><i class="icon-exit"></i><locale:message code="label.exit"/></a></li>
        </ul>
    </div>
</h2>
<script type="text/javascript">

    function DropDown(el) {
        this.dd = el;
        this.initEvents();
    }
    DropDown.prototype = {
        initEvents : function() {
            var obj = this;

            obj.dd.on('click', function(event){
                $(this).toggleClass('active');
                event.stopPropagation();
            });
        }
    };

    $(function() {

        var dd = new DropDown( $('#dd') );

        $(document).click(function() {
            $('.settings').removeClass('active');
        });

    });

</script>
</body>
</html>
