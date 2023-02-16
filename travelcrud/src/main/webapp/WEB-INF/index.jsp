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
    <title>Travel Save </title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <h1>Save Travels</h1>
    <table class="table">
      <thead>
        <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>
        <th>Actions</th>
      </thead>
      <c:forEach var="travel" items="${travels}">
        <tr>
          <td>
            <a href="/travel/${travel.id}">${travel.expense}</a>
        </td>
          <td>${travel.vendor}</td>
          <td>${travel.amount}</td>
          <td class="d-flex">
            <a href="/travel/edit/${travel.id}">Edit</a>
            <form action="/expenses/${travel.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
    <div class="container">
        <h2>Add an expense:</h2>
        <form:form action="/expenses" method="post" modelAttribute="travel">
            <div>
                <form:errors class="alert-danger" path="expense"/>
            </div>
            <div>
                <form:errors class="alert-danger" path="vendor"/>
            </div>

            <div class="form-control">
                <form:label path="expense">expense</form:label>
                <form:input path="expense"></form:input>
            </div>
            <div class="form-control">
                <form:label path="vendor">vendor</form:label>

                <form:input path="vendor"></form:input>
            </div>
            <div class="form-control">
                <form:label path="amount">amount</form:label>
                <form:input path="amount"></form:input>
            </div>
            <input type="submit" value="Log It">
        </form:form>
    </div>
  </body>
</html>
