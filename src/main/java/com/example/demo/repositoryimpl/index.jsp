<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>WELCOME TO TOMCAT SERVER USING JSP</h1>

    <%
        int a = 10;
        int b = 20;
        int c = a + b;
    %>

    <p>Answer : <%= c %></p>

</body>
</html>