<%-- 

 		                     /$$        /$$$$$$  /$$
 		  /$$$$$$$  /$$$$$$ | $$$$$$$ |__/  \ $$ /$$
 		 /$$_____/ |____  $$| $$__  $$  /$$$$$$/| $$
 		|  $$$$$$   /$$$$$$$| $$  \ $$ /$$____/ | $$
 		 \____  $$ /$$__  $$| $$  | $$| $$      | $$
 		 /$$$$$$$/|  $$$$$$$| $$$$$$$/| $$$$$$$$| $$
 		|_______/  \_______/|_______/ |________/|__/                         
                           ~ Departement - SSI
                            ~ @author martinsa 
  

    Document   : getquotes
    Created on : 30 oct. 2015, 16:53:24
    Author     : martinsa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listing Quotes</title>
    </head>
    
    <body>
        <h1>Listing Quotes</h1>
    
        <br/>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="admin/managequotes.do">Manage Quotes</a><br/>
        </sec:authorize>
            <a href="authentication/logout.do">Logout</a>
        <br/>
        <c:forEach var="quote" items="${quotes}">
            <table border="1" style="width: 600px">
            <col width="130"/>
            <col width="200"/>
            <tr>
                <td>Name</td>
                <td style="background-color: gray">${quote.name}</td>
            </tr>
            <tr>
                <td>Quote Sign</td>
                <td>MTSI</td>
            </tr>
            <tr>
                <td>Last Value:</td>
                <td><c:out value="${quote.last}"/></td>
            </tr>
            <tr>
                <td>Date</td>
                <td><c:out value="${quote.date}"/></td>
            </tr>
            <tr>
                <td>Time</td>
                <td><c:out value="${quote.time}"/></td>
            </tr>
            <tr>
                <td>Change</td>
                <td><c:out value="${quote.change}"/></td>
            </tr>
            <tr>
                <td>Open</td>
                <td><c:out value="${quote.open}"/></td>
            </tr>
            <tr>
                <td>High</td>
                <td><c:out value="${quote.high}"/></td>
            </tr>
            <tr>
                <td>Low</td>
                <td><c:out value="${quote.low}"/></td>
            </tr>
            <tr>
                <td>Previous Close</td>
                <td><c:out value="${quote.previousClose}"/></td>
            </tr>
            <tr>
                <td>Percentage Change</td>
                <td><c:out value="${quote.percentageChange}"/></td>
            </tr>
        </table>
        <br/>
    </c:forEach>
    </body>
</html>
