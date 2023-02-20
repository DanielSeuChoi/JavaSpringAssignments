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
    <title>Book Shelf</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />

    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="d-flex justify-content-between p-3">
      <h1>${book.title}</h1>
      <a href="/welcome">Back to shelves</a>
    </div>
    <div class="p-3">
      <span>${book.user.userName} read ${book.title} by ${book.author}</span>
      <p>Here are ${book.user.userName}'s thoughts:</p>
    </div>

    <div class="container">
      <hr />
      <p><c:out value="${book.description}"></c:out></p>
      <hr />
      <div>
        <c:if test="${userId==book.user.id}">
          <a href="/books/${book.id}/edit">Edit Book</a>
          <a href="/books/${book.id}/delete">Delete Entry</a>
        </c:if>
      </div>
    </div>
  </body>
</html>
