<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  <form action="./memberJoin" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
    </div>
    
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
    <div class="form-group">
      <label for="files">File:</label>
      <input type="file" class="form-control" id="files" name="files">
    </div>
    

    <button type="submit" class="btn btn-default">Submit</button>
  
  </form>
</div>




</body>
</html>