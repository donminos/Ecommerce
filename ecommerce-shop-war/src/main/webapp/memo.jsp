<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <title>JSP Page</title>
        
    </head>
    <body>

        <form name='f' action="login" method='POST'>
            <table>
                <tr>
                    <td><label id="usuario"></label></td>
                    <td><input type='text' name='username' value=''></td>
                </tr>
                <tr>
                    <td><label id="contrasena"></label></td>
                    <td><input type='password' name='password' /></td>
                </tr>
                <tr>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <td><input name="submit" type="submit" value="submit" /></td>
                </tr>
            </table>
        </form>        
</body>


<script src="resources/js/index.js"></script>
</html>