<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Register</title>
    </head>
    <body>
        <br />
        <p><b>Student Register</b></p>
        <form name="frmAddUser" action="ProfileServlet" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="username" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>IC No: </td>
                        <td><input type="text" name="icno" value="" size="40" required /></td>
                    </tr>
                    <tr>
                        <td>First Name: </td>
                        <td><input type="text" name="firstName" value="" size="40" required /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert"/></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit" name="submit" />
                            <input type="reset" value="Cancel" name="cancel"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
