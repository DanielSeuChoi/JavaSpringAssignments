<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show fortune</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="container">
		<h2>Here's your Omikuji</h2>
	<div class="backcolor">
		<p>In <c:out value="${pickNum}"/> years, you will live in <c:out value="${city}"/>
			with <c:out value="${person}"/> as your roommate, <c:out value="${profession}"/>
			for a living. The next time you see a <c:out value="${living}"/>, you will have
			good luck. Also, <c:out value="${nice}"/>
		</p>
	</div>
	<div>
		<a href='/'>Go Back</a>	
	</div>
</div>

</body>
</html>