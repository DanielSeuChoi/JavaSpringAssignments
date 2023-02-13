<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
    </head>
<body>
    <div class="container">
    <h1>Fruit Store</h1>
    <table class="table">
    <tr>
	 	<th>Fruit</th>
	    <th>Price</th>
    </tr>
        <c:forEach var="fruit" items="${fruitsControl}">
    <tr>
    	<td>
    	<c:out value="${fruit.name}"/>
    	</td>
    	<td>
   		<c:out value="${fruit.price }"/>
    	</td>
    </tr>
   	    </c:forEach>
    </table>
    </div>
</body>
</html>