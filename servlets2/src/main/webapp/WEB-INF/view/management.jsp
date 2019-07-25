<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management Users</title>
</head>
<body>
<h1 align="center">All users</h1>

<c:forEach var="user" items="${requestScope.users}">
    <ul>
        <li>First name: <c:out value="${user.firstName}"/></li>
        <li>Last name: <c:out value="${user.lastName}"/></li>
        <li>Username: <c:out value="${user.username}"/></li>
        <li>Role: <c:out value="${user.role}"/></li>
    </ul>

    <table>
        <tr>
            <td>
                <div>
                    <form method="get" action="/management/update">
                        <input type="text" hidden name="username" value="${user.username}">
                        <input type="submit" value="Update">
                    </form>
                </div>
            </td>
            <td>
                <div>
                    <form method="post" action="/management/delete">
                        <input type="text" hidden name="username" value="${user.username}">
                        <input type="submit" name="delete" value="Delete">
                    </form>
                </div>
            </td>
        </tr>
    </table>

    <hr>
</c:forEach>

<h2>Create new user</h2>
<form method="post" action="/management">
    <lable>First name <input type="text" name="firstName"></lable>
    <br>
    <lable>Last name <input type="text" name="lastName"></lable>
    <br>
    <lable>Username <input type="text" name="username"></lable>
    <br>
    <lable>Password <input type="text" name="password"></lable>
    <br>
    <lable>Username <select name="role">
        <option>user</option>
        <option>admin</option>
    </select></lable>

    <input type="submit" value="Submit" name="ok"><br>
</form>
</body>
</html>
