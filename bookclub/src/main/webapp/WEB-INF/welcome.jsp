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
      <h1>Welcome, ${user.userName}</h1>
      <a href="/logout">Log out</a>
      <a href="/books/new">Add to my shelf!</a>
    </div>
    <div>
      <table class="table">
        <thead>
          <th>ID</th>
          <th>Title</th>
          <th>Author Name</th>
          <th>Posted By</th>
        </thead>
        <c:forEach var="book" items="${book}">
          <tr>
            <td>${book.user.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.user.userName}</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
