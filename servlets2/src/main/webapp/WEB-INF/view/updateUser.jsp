<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user: <c:out value="${requestScope.user.username}"/></title>
</head>
<body>
<form method="get" action="/management/update">
    <div>First name: <c:out value="${requestScope.user.firstName}"/></div>
    <div>Last name: <c:out value="${requestScope.user.lastName}"/></div>
    <div>Username: <c:out value="${requestScope.user.username}"/></div>
</form>

<br>

<form method="post" action="/management/update">
    <label>First name: <input type="text" name="firstName"/></label><br>
    <label>Last name: <input type="text" name="lastName"/></label><br>
    <label>Username: <input type="text" name="username"/></label><br>

    <input type="submit" value="Update" name="update"><br>
</form>
</body>
</html>
