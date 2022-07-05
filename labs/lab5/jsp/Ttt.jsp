<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="tglb1" prefix="taglib" %>
<html>
<head>
    <title>
        Lab5
    </title>
</head>
<body>
<%--использование тела и предназначенный для  создания  html-тега <form>, генерирующего http-запрос типа  POST --%>
<taglib:dossier action="/lab5/Ttt">
    <br/><taglib:surname value="Drugov"/>
    <br/><taglib:lastname value="Anton"/>
    <br><taglib:sex/>
    <br><taglib:submit/>
</taglib:dossier>
</body>
</html>