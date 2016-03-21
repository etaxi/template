<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP page</title>
</head>
<body>

    <h1>Hello from JSP file!</h1>

    <%
        System.out.println( "Calculating 2 + 4= " + 2+3 );
        User user = new User(123, "Vasja", "Pupkin");
    %>

    <p>
        Customer Age: <input type=int name=age value=<%= user.getFirstName() %> >
    </p>

    <%= user.toString() %>

</body>
</html>
