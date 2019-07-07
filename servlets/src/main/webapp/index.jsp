<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome!</title>
</head>
<title>Home page</title>
<meta charset="UTF-8">


<body>
<h1>Welcome page</h1>
<a href="${pageContext.request.contextPath}/user/login" method="get">Login</a>
<br>
<h2>All users</h2>
<c:forEach var="user" items="${requestScope.dao}">
    <ul>
        <li>Name: <c:out value="${user.id}"/></li>
    </ul>
</c:forEach>
</body>
</html>
