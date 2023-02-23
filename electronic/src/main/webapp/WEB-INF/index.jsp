<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
    />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>Document</title>
  </head>
  <body>
    <div class="container">
      <h2>Home Page</h2>
      <div>
        <a href="/product/new">New Product</a>
      </div>
      <div>
        <a href="/category/new">New Category</a>
      </div>
      <hr />
      <div class="d-flex justify-content-around">
        <div>
          <h2>Products</h2>
          <c:forEach var="product" items="${products}">
            <ul>
              <li>
                <c:out
                  ><a href="products/${product.id}">${product.name}</a></c:out
                >
              </li>
            </ul>
          </c:forEach>
        </div>
        <div>
          <h2>Category</h2>
          <c:forEach var="category" items="${category}">
            <ul>
              <li><a href="">${category.name}</a></li>
            </ul>
          </c:forEach>
        </div>
      </div>
    </div>
  </body>
</html>
