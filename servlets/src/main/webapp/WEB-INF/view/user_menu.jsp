<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        <%= request.getSession().getAttribute("role") %>
    </title>
</head>
<body>

<h1>
    <%= request.getSession().getAttribute("login") %> is logged in!<br>
    Role is <%= request.getSession().getAttribute("role") %>
</h1>
<a href="<c:url value='/logout' />">Logout</a>
</body>
</html>
