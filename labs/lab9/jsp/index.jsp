<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<html>
<head>
    <title>
        Lab9
    </title>
</head>
<body>

<form method="post" action="/lab9/Ccc">
    <input type="text" name="value1" placeholder="value1"/><br>
    <input type="text" name="value2" placeholder="value2"/><br>
    <input type="text" name="value3" placeholder="value3"/><br>
    <input type="text" name="cbean" placeholder="cbean"/><br>
    <button>Post on the Ccc</button>
</form>

<form method="get" action="/lab9/ccc.jsp">
    <input type="text" name="value1" placeholder="value1"/><br>
    <input type="text" name="value2" placeholder="value2"/><br>
    <input type="text" name="value3" placeholder="value3"/><br>
    <input type="text" name="cbean" placeholder="cbean"/><br>
    <button>Get on the сcc.jsp(task2)</button>
</form>

</body>
</html>
