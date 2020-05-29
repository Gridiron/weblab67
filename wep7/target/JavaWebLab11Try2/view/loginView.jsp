<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="locale" />
<html>
<head>
    <title><fmt:message key="homePage.login" /></title>
    <link href="http://localhost:8080/wep7_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<form  class="page-form" id="set-worker-to-job" method = "POST">
    <fmt:message key="login.login" />: <input type = "text"  required="required" name = "login">
    <fmt:message key="login.password" />: <input type = "password"  required="required" name = "password">
    <input type = "submit" value = <fmt:message key="form.submit" /> />
</form>
<p style="color: red;">${errorString}</p>

</body>
</html>