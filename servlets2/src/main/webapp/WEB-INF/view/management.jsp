<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Dynamic Editable HTML Table using Javascript, Jquery and Bootstrap with add, edit, and Delete Options</title>
    <!-- CSS files-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<h1 class="col-md-12 text-center" style="color: black">All users</h1>

<br>
<div class="table-responsive col-md-10">

    <table class="table table-bordered table-striped table-hover table-condensed  text-center" id="DyanmicTable">
        <thead>
        <tr>
            <th class="text-center">
                First name
            </th>
            <th class="text-center">
                Last name
            </th>
            <th class="text-center">
                Username
            </th>
            <th class="text-center">
                Role
            </th>
            <th class="text-center">
                Actions
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td>
                    <c:out value="${user.firstName}"/>
                </td>
                <td>
                    <c:out value="${user.lastName}"/>
                </td>
                <td>
                    <c:out value="${user.username}"/>
                </td>
                <td>
                    <c:out value="${user.role}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

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
</div>
<!--JS Files-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script src="singolo-template/js/bootstable.min.js"></script>
<script>
    $('#DyanmicTable').SetEditable({$addButton: $('#addNewRow')});
</script>
</body>
</html>