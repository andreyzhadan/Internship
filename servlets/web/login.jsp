<%--
  Created by azhadan on 7/29/13.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h2>Login page</h2>

<form action="/jkinopoisk" method="post">
    <label>Name:
        <input type="text" name="login"/>
    </label>
    <label>Password:
        <input type="password" name="password"/>
    </label>
    <input type="submit" value="Login"/>
</form>

</body>
</html>