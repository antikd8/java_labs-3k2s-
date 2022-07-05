<%@ page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>laba4</title>
    <%! int time = printGreeting();

        protected int printGreeting() {
        if (LocalDateTime.now().getHour() > 6 && LocalDateTime.now().getHour() < 12)
            return 1;
        if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 16)
            return 2;
        if (LocalDateTime.now().getHour() >= 17 && LocalDateTime.now().getHour() <= 20)
            return 3;
        if (LocalDateTime.now().getHour() >= 21 || LocalDateTime.now().getHour() <= 6)
            return 4;
        return 0;
        } %>

</head>
<body>
    <%
        switch (printGreeting()) {
        case 1:{ %>
            <%@include file="morning.jsp"%>
            <jsp:include page="morning.jsp"/>
          <%--<jsp:forward page="morning.jsp"/>--%>
    <%break;
        }
        case 2:{ %>
            <%@ include file="afternoon.jsp"%>
            <jsp:include page="/afternoon"/>
            <jsp:forward page="afternoon.jsp"/>
    <% break;
        }
        case 3:{ %>
            <%@ include file="evening.jsp"%>
            <jsp:include page="evening.jsp"/>
            <jsp:forward page="evening.jsp"/>
    <% break;
        }

        case 4:{ %>
             <%@include file="night.jsp"%>
           <%-- <jsp:include page="night.jsp"/> --%>
           <%-- <jsp:forward page="night.jsp"/> --%>
    <!--выводимый комментарий--> <%// невыводимый комментарий%>
    <%break;
        }
    }%>

    <form action="Jjj" method="post">
        <input type="submit" value="POST to Jjj"/>
    </form>

    <form action="Jjj" method="get">
        <input type="submit" value="GET to Jjj"/>
    </form>
    <script type="text/javascript">
        <%@ include file="script.js"%>
        CreateTable();
    </script>
</body>
</html>