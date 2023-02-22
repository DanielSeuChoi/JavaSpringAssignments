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
    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="d-flex justify-content-between p-2">
      <h1>Welcome, ${user.userName}</h1>
      <a href="/logout">Log out</a>
    </div>
    <div class="d-flex justify-content-between p-2">
      <h4>Books from everyone's shelves:</h4>
      <a href="/books/new">Add to shelf!</a>
    </div>
    <div class="container">
      <table class="table">
        <thead>
          <th>ID</th>
          <th>Title</th>
          <th>Author Name</th>
          <th>Posted By</th>
          <th>Borrow</th>
        </thead>
        <c:forEach var="book" items="${books}">
          <c:if test="${user.id!=book.borrower.id}">
            <tr>
              <td>${book.id}</td>
              <td>
                <a path="${book.id}" href="/books/${book.id}">${book.title}</a>
              </td>
              <td>${book.author}</td>
              <td>${book.user.userName}</td>
              <c:if test="${user!=book.user}">
                <td><a href="books/${book.id}/borrow">Borrow</a></td>
              </c:if>
            </tr>
          </c:if>
        </c:forEach>
      </table>

      <table class="table">
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Author Name</th>
          <th>Owner</th>
          <th>Return</th>
        </tr>
        <c:forEach var="book" items="${books}">
          <c:if test="${user.id==book.borrower.id}">
            <tr>
              <td><c:out value="${book.id}" /></td>
              <td>
                <a href="/books/${book.id}"><c:out value="${book.title}" /></a>
              </td>
              <td><c:out value="${book.author}" /></td>
              <td><c:out value="${book.user.userName}" /></td>
              <c:if test="${user!=book.user}">
                <td><a href="books/${book.id}/return">return</a></td>
              </c:if>
            </tr>
          </c:if>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
