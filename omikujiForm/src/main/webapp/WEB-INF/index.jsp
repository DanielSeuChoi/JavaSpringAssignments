<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Omikuji</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
    </head>
<body>
	<div class="container">
	    <h3>Login</h3>
	    <form action='/createOmikuji' method='POST'>
		<label>Pick any number from 5 to 25:</label>
	    	<input type="number" min=5 max=25 name='pickNum'>
		<label>Enter the name of any city:</label>
	    	<input type='text' name='city'>
   		<label>Enter the name of any real person:</label>
	    	<input type='text' name='person'>
   		<label>Enter professional endeavor or hobby:</label>
	    	<input type='text' name='profession'>
		<label>Enter any type of living thing:</label>
	    	<input type='text' name='living'>
   		<label>Say something nice to someone:</label>
	    	<textarea  name='nice'></textarea>
	    	<input type='submit'>
	    </form>
	</div>
</body>
</html>