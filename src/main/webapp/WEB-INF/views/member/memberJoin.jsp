<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Join</title>

<c:import url="../template/boot.jsp" />

</head>
<body>

<c:import url="../template/nav.jsp" />


<h1>M e m b e r   J o i n</h1>

<div class="container">
  <h2>J O I N</h2>
	<form:form action="./memberJoin" modelAttribute="memberVO" method ="post" enctype="multipart/form-data">
		<div class="form-group">
	      <label for="id">ID:</label>
	      <form:input path="id" placeholder="Enter id" class="form-control" id="id"/>
	   	  <form:errors path="id"/>
	    </div>
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <form:password path="pw" class="form-control" id="pw" placeholder="Enter password" />
	      <form:errors path="pw" cssStyle="color:red"/>
	    </div>
	    <div class="form-group">
	      <label for="pw2">Password:</label>
	      <form:password path="pw2" class="form-control" id="pw2" placeholder="Enter password" />
	      <form:errors path="pw2" cssStyle="color:red"/>
	    </div>
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <form:input path="name" class="form-control" id="name" placeholder="Enter name" />
	    </div>
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <form:input path="email" class="form-control" id="email" placeholder="Enter email" />
	    </div>
	    <div class="form-group">
	      <label for="files">File:</label>
	      <input type="file" class="form-control" id="files" name="files">
	    </div>
	    <button type="submit" class="btn btn-default">Submit</button>
	</form:form>
	
</div>




</body>
</html>