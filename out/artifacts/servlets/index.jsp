<%--
  Created by azhadan on 7/30/13.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
<h2>Index page</h2>

<form action="/mathit" method="post">
    Type your name: <input type="text" name="name"/> <br/><br/>
    Lets do some math?<br/>
    Type the first value to be added: <input type="text" name="value1"/> <br/>
    Type the second value to be added: <input type="text" name="value2"/> <br/><br/>
    <input type="submit" value="Do some math"/>
</form>
</body>
</html>