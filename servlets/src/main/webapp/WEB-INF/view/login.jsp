<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1>Login</h1><br>
<form action="/user/login" method="post">
    <input type="text" required placeholder="login" name="login"><br>
    <input type="password" required placeholder="password" name="password"><br><br>
    <input class="button" type="submit" value="Sign in">
</form>
</body>
</html>
