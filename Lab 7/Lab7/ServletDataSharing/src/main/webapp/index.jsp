<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample Perform CRUD Using Java Servlet</title>
    </head>
    <body>
        <h1>Sample Perform CUD Using Jsva Servlet</h1>
        <%--<jsp:forward page="/UserController?action=listUser" />--%>
        <jsp:forward page="/ProfileServlet?action=insert" />
    </body>
</html>
