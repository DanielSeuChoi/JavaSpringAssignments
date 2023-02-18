<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Login and Registration</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="container">
        <h2>Register</h2>
        <form:form action="/register" method="post" modelAttribute="newUser">
            <div>
                <form:errors class="alert-danger" path="userName"/>
            </div>
            <div>
                <form:errors class="alert-danger" path="email"/>
            </div>
            <div>
                <form:errors class="alert-danger" path="password"/>
            </div>
            <div>
                <form:errors class="alert-danger" path="confirm"/>
            </div>

            <div class="form-control">
                <form:label path="userName">Username:</form:label>
                <form:input path="userName"></form:input>
            </div>
            <div class="form-control">
                <form:label path="email">Email:</form:label>

                <form:input path="email"></form:input>
            </div>
            <div class="form-control">
                <form:label path="password">Password:</form:label>
                <form:input path="password"></form:input>
            </div>
            <div class="form-control">
                <form:label path="confirm">Confirm Password:</form:label>
                <form:input path="confirm"></form:input>
            </div>
            <input type="submit" value="Create">
        </form:form>
    </div>
    <div class="container">
        <h2>Login</h2>
        <form:form action="/login" method="post" modelAttribute="newLogin">
            <div>
                <form:errors class="alert-danger" path="email"/>
            </div>
            <div>
                <form:errors class="alert-danger" path="password"/>
            </div>
            <div class="form-control">
                <form:label path="email">Email:</form:label>
                <form:input path="email"></form:input>
            </div>
            <div class="form-control">
                <form:label path="password">Password:</form:label>
                <form:input path="password"></form:input>
            </div>
            <input type="submit" value="Log In">
        </form:form>
    </div>
  </body>
</html>
