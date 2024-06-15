<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Register</title>
    </head>
    <body>
        <p>Confirm Register</p>
        <form name="frmEditUser" action="ProfileServlet" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User ID:</td>
                        <td><input type="text" name="profileId" readonly="readonly" value="<c:out value="${profile.username}" />" size="25" /></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="firstName" value="<c:out value="${profile.icno}" />" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName" value="<c:out value="${profile.firstName}" />" size="40" /></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" value="confirm" name="action" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit" name="submit" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>