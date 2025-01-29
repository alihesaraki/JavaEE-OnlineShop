<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="j_security_check" method="post">
    <input type="text" name="j_username">
    <input type="text" name="j_password">
    <input type="submit" value="Login">

</form>
</body>
</html>
