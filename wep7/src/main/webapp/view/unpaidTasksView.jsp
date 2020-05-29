<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="locale" />
<html>
<head>
    <title><fmt:message key="homePage.unpaidTasks" /></title>
    <link href="http://localhost:8080/wep7_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<h3><fmt:message key="homePage.unpaidTasks" /></h3>

<p style="color: red;">${errorString}</p>
<mytagtld>werwerwer</mytagtld>
<table border="1" cellpadding="5" cellspacing="1" style="border-collapse: collapse">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Rank needed</th>
        <th>Unpaid</th>
        <th>Worker id</th>
        <th>Client id</th>
    </tr>
    <c:forEach items="${unpaidTasks}" var="task" >
        <tr>
            <td>${task.task_id}</td>
            <td>${task.name}</td>
            <td>${task.rank_needed}</td>
            <td>${task.is_paid}</td>
            <td>${task.workerId}</td>
            <td>${task.clientId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>