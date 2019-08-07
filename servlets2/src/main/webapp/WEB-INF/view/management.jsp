<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Management</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <script src="https://code.jquery.com/jquery-migrate-3.0.0.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 70%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<center>
    <h1 style="text-align:center">ALL USERS<br/></h1>

    <div class="container">
        <table id="usersTable" class="table">
            <thread>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Username</th>
                    <th>Actions</th>
                </tr>
            </thread>
        </table>
    </div>

    <p><br/></p>

    <div>
        <button id="createUserForm"><h3>Create new user</h3></button>
    </div>

    <div id="registrationForm" title="Registration form">
        <form id="registration">
            <center>
                <label for="firstName">First name</label>
                <input type="text" name="firstName" id="firstName" class="text ui-widget-content ui-corner-all"
                       required>
                <label for="lastName">Last name</label>
                <input type="text" name="lastName" id="lastName" class="text ui-widget-content ui-corner-all">
                <label for="username">Username</label>
                <input type="text" name="username" id="username" class="text ui-widget-content ui-corner-all" required>
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="text ui-widget-content ui-corner-all"
                       required>
                <button id="createUser">Create new user</button>
            </center>
        </form>
    </div>

    <div id="formForUpdate" title="Update form">
        <form id="updateForm">
            <center>
                <label for="firstNameUpdate">Values for update: First name</label>
                <input type="text" name="firstNameUpdate" id="firstNameUpdate"
                       class="text ui-widget-content ui-corner-all">
                <label for="lastNameUpdate">Last name</label>
                <input type="text" name="lastNameUpdate" id="lastNameUpdate"
                       class="text ui-widget-content ui-corner-all">
                <label for="usernameUpdate">Username</label>
                <input type="text" name="usernameUpdate" id="usernameUpdate"
                       class="text ui-widget-content ui-corner-all">
                <button id="update" onclick="updateUser">Update user</button>
            </center>
        </form>
    </div>
</center>

<script>

    $.getJSON("${pageContext.request.contextPath}/users", function (data) {
        var users = [];
        $.each(data, function (key, user) {
            users.push("<tr>");
            users.push("<td id=''" + key + "''>" + user.firstName + "</td>");
            users.push("<td id=''" + key + "''>" + user.lastName + "</td>");
            users.push("<td id=''" + key + "''>" + user.username + "</td>");
            users.push("<td>" + "<button id='updateUser' type='button' onclick='updateUser(`" + user.username + "`)'>" + "update" + "</button>" + " | " + "<button id='deleteUser' type='button' onclick='deleteUser(`" + user.username + "`)'>" + "delete" + "</button>" + "</td>" + "</td>");
            users.push("</tr>");
        });
        $("<tbody/>", {html: users.join("")}).appendTo("table");
    })
        .done(function () {
            console.log("Table of users has been got");
        })
        .fail(function () {
            console.log("Error: table of users has not been got");
        });

    var dialog = $("#registration").dialog({autoOpen: false});
    $("#createUserForm").click(function () {
        dialog.dialog("open");
    });

    $('#createUser').click(function () {
        var newUser = new Object();
        newUser.firstName = $('#firstName').val();
        newUser.username = $('#username').val();
        newUser.password = $('#password').val();
        if ($('#lastName') != "") {
            newUser.lastName = $('#lastName').val();
        }

        $.ajax({
            url: "${pageContext.request.contextPath}/user",
            type: 'POST',
            data: JSON.stringify(newUser),
            contentType: 'application/json',
            dataType: 'json'
        })
            .done(function () {
                console.log("User has been created");
            })
            .fail(function () {
                console.log("Error: User has not been created");
            });
    });

    $(function () {
        $("#updateForm").dialog({
            autoOpen: false,
        });
    });

    // function updateUser(username) {
    //     $("#updateForm").dialog("open");
    //
    //     $.ajax({
    //         url: '/management/user?username=' + username + "&firstname=" + "Alex" + "&lastname=" + "Popov",
    //         type: 'PUT',
    //         contentType: "application/json; charset=utf-8",
    //         dataType: 'json',
    //         success: function (data) {
    //             data.firstName = $('#firstNameUpdate').val();
    //             data.lastName = $('#lastNameUpdate').val();
    //             //data.username = $('#usernameUpdate').val();
    //         },
    //         error: function (error) {
    //             alert(error);
    //         }
    //     });
    // };

    function deleteUser(username) {
        var usernameForDelete = username;
        var askPermission = confirm("Are you sure?");
        if (askPermission == true) {
            console.log("Delete user with username: " + usernameForDelete);
            $.ajax({
                url: ${pageContext.request.contextPath}'/user?username=' + username,
                type: 'DELETE',
                data: JSON.stringify(usernameForDelete),
                contentType: 'application/json',
                dataType: 'json'
            })
            location.reload();
        }
    };
</script>
</body>
</html>