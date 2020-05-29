<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="locale" />
<html>
<head>
    <title><fmt:message key="homePage.registration" /></title>
    <link href="http://localhost:8080/wep7_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<p style="color: red;">${errorString}</p>
<form  class="page-form" id="set-worker-to-job" method = "POST">
    <fmt:message key="homePage.login" />: <input type = "text"  required="required" name = "login">
    <fmt:message key="login.password" />: <input type = "password"  required="required" name = "password">
    <fmt:message key="registration.confirmpass" />: <input type = "password"  required="required" name = "password_confirm">
    <input type = "submit" value = <fmt:message key="form.submit" /> />
</form>
</body>
</html>