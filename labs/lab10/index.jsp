<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

<div style="margin-left: 500px; margin-top: 150px;">
    <br><br>
    <form action="DBConnection" method="get">
        <input type="submit" value="task 2 (static select)" size="20">
    </form>
    <form action="DBConnection2" method="get">
        <input id="id" name="id" type="number" min="1" max="1200" style="width: 120px" pattern="[0-9]" placeholder="put here id(int)">
        <input type="submit" value="task 3 (select with markers)" size="20">
    </form>
    <form action="DBConnection3" method="get">
        <input id="name" name="name" placeholder="put here name(string)">
        <input type="submit" value="task 4 (call stored procedure)" size="20">
    </form>

</div>

</body>
</html>
