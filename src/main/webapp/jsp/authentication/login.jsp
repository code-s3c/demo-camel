<%-- 


                             /$$        /$$$$$$  /$$
          /$$$$$$$  /$$$$$$ | $$$$$$$ |__/  \ $$ /$$
         /$$_____/ |____  $$| $$__  $$  /$$$$$$/| $$
        |  $$$$$$   /$$$$$$$| $$  \ $$ /$$____/ | $$
         \____  $$ /$$__  $$| $$  | $$| $$      | $$
         /$$$$$$$/|  $$$$$$$| $$$$$$$/| $$$$$$$$| $$
        |_______/  \_______/|_______/ |________/|__/                         
        
    Document   : login
    Created on : 26 oct. 2015, 12:22:03
    Author     : martinsa
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login page</title>
        <link href="<c:url value='/assets/static/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/assets/static/css/app.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    </head>
    
    <body>
        <div id="mainWrapper">
            <div class="login-container">
                <div class="login-card">
                    <div class="login-form">
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger">
                                    <p>${error}</p>
                                </div>
                            </c:if>
                            
                            <c:if test="${not empty logout}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                            </div>
                            
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                            </div>
                            
                            <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />

                            <div class="form-actions">
                                <input type="submit"
                                       class="btn btn-block btn-primary btn-default" value="Log in">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>