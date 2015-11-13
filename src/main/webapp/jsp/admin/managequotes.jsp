<%-- 
    Document   : viewquotes
    Created on : 2 nov. 2015, 16:23:22
    Author     : martinsa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Quotes</title>
    </head>

    <body>
        <h1>Manage Quotes</h1>
        
        <a href="../">Return to main view</a><br/>
        <table border="1">
            <thead>Existing Symbols</thead>
            <tr>
                <td>Symbol</td>
                <td>Authorized Roles</td>
            </tr>
            <c:forEach var = "quote" items="${quotes}">
                <tr>
                    <form action="./removequotesymbol.do" method="POST">
                        <td><input type="text" name="symbol" value="${quote.name}" readonly/></td>
                        <td></td>
                        <!-- csrf token -->
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <td><input type="submit" value="Remove"/></td>
                    </form>
                </tr>
            </c:forEach>
        </table>

        <form action="./addquotesymbol.do" method="POST">
            <table border="1">
                <thead>New Symbol</thead>
                <tr>
                    <td>Symbol</td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="symbol"/>
                        <input type="hidden" name="${_csrf.parameterName}" 
                               value="${_csrf.token}" />
                    </td>
                    <td><input type="submit" value="Add"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
