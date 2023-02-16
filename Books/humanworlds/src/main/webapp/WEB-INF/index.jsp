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
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="/js/app.js"></script>
  </head>
  <body>
    <div class="container">
      <table>
        <tr>
          <th>Title</th>
        </tr>
        <tr>
          <td>${books.title}</td>
        </tr>
      </table>

      <h1>Book Store</h1>
      <form action="createBook" method="POST">
        <label>Title:</label>
        <input type="text" name="title" />
        <label>Description:</label>
        <textarea name="description"></textarea>
        <label>Language:</label>
        <input type="text" name="language" />
        <label>Number of Pages:</label>
        <input type="text" name="pages" />
        <input type="submit" />
      </form>
    </div>
  </body>
</html>
