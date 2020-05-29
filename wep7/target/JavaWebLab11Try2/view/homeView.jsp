
<%@ page import="model.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="locale" />

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link href="http://localhost:8080/wep7_war_exploded/view/styles.css" rel="stylesheet">
</head>

<body>
<form method="POST">
    <select id="lang" name="lang" onchange="submit()">
        <option>Default</option>
        <option value="ru" ${lang == 'ru' ? 'selected' : ''}>Russian</option>
        <option value="en" ${lang == 'en' ? 'selected' : ''}>English</option>
    </select>
</form>
<p  style="color: red;">${errorString}</p>
<%User user = (User)session.getAttribute("user"); %>
<%int userType = (user == null ? -1 : user.getUser_type()); %>
<%if (userType == -1) {%>
<h3><fmt:message key="homePage.title" /></h3>
<%} else if (userType == 0) { %>
<h2><fmt:message key="homePage.userTitle"/></h2>
<%} else if (userType == 1) { %>
<h2><fmt:message key="homePage.adminTitle"/></h2>
<%}%>
<div >
    <%if (userType == -1) {%>
    <button class="return-button" onclick="location.href='${pageContext.request.contextPath}?command=login'"><fmt:message key="homePage.login" /></button>
    <button class="return-button" onclick="location.href='${pageContext.request.contextPath}?command=registration'"><fmt:message key="homePage.registration" /></button>
    <%} else {%>
    <button class="return-button" onclick="location.href='${pageContext.request.contextPath}?command=logout'"><fmt:message key="homePage.logout" /></button>

    <%}%>
</div>
<%if (userType >= 0) {%>
<b  class="info-box"><fmt:message key="homePage.choose" /></b>
<div class="numberlist">
    <ol>
        <li><a href="${pageContext.request.contextPath}?command=unpaidTasks"><fmt:message key="homePage.unpaidTasks" /></a></li>
        <li><a href="${pageContext.request.contextPath}?command=clientInfo"><fmt:message key="homePage.clientInfo" /></a></li>
        <li><a href="${pageContext.request.contextPath}?command=workersWithRank"><fmt:message key="homePage.workersWithRank" /></a></li>
    </ol>
</div>
<%}%>
</body>
</html>