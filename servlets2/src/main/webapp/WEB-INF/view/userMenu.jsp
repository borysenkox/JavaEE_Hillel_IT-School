<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="../../AccessPages/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="../../AccessPages/css/style.css">
</head>
<body>

<div class="main">
    <section class="sign-in">
        <div class="container">
            <div class="signin-form">
                <h2 class="form-title">Welcome, <%= request.getSession().getAttribute("username")%></h2>
                <form action="/user/logout" method="POST" class="register-form" id="login-form">
                    <ul>
                        <li>First name: <%= request.getSession().getAttribute("firstName")%></li>
                        <li>Last name: <%= request.getSession().getAttribute("lastName")%></li>
                        <li>Role: <%= request.getSession().getAttribute("role")%>
                        <li>Status: <%= request.getSession().getAttribute("status")%>
                        </li>
                    </ul>
                    <div class="form-group form-button">
                        <input type="submit" name="signin" id="signin" class="form-submit" value="Sign out"/>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<!-- JS -->
<script src="../../AccessPages/vendor/jquery/jquery.min.js"></script>
<script src="../../AccessPages/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>