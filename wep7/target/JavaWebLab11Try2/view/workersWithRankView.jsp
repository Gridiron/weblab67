<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="locale" />
<html>
<head>
    <title><fmt:message key="homePage.workersWithRank" /></title>
    <link href="http://localhost:8080/wep7_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<h3><fmt:message key="homePage.workersWithRank" /></h3>
<form method = "POST">
    Rank: <input type = "number" min="0" name = "rank">
    <input type = "submit" value = "Submit" />
</form>
<p style="color: #ff0000;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" style="border-collapse: collapse">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Rank</th>
    </tr>
    <c:forEach items="${workersWithRank}" var="worker" >
        <tr>
            <td>${worker.worker_id}</td>
            <td>${worker.name}</td>
            <td>${worker.rank}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
