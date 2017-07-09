<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Signup</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script
  src="https://code.jquery.com/jquery-3.2.0.js"
  integrity="sha256-wPFJNIFlVY49B+CuAIrDr932XSb6Jk3J1M22M3E2ylQ="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="js/userDatepickerConfig.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="content"></div>
<nav class="navbar">
<ul>
  <li><a class="active"  href="#home">Cafe-Chat</a></li>
  <li style="float:right; font-size: -webkit-xxx-large;"><a href="#about">Login</a></li>
</ul>
</nav>

<div class="container">
  <div class="col-md-6 col-md-offset-3">
    <h1>Sign up</h1>
    <hr>
  </div>
  <div class="col-md-6 col-md-offset-3">
<form class="form" id="new_user" enctype="multipart/form-data" action="User" accept-charset="UTF-8" method="post">
  <label for="user_first_name">First name</label>
  <input class="form-input" type="text" name="first_name" id="user_first_name">

  <label for="user_last_name">Last name</label>
  <input class="form-input" type="text" name="last_name" id="user_last_name">


  <label for="user_date_of_birth">Date of birth</label>
  <input id="userDatepicker" class="form-input" type="text" name="date_of_birth">

 
  <label for="user_email">Email</label>
  <input class="form-input" type="email" name="email" id="user_email">
  
  <label for="user_password">Password</label>
  <input class="form-input" type="password" name="password" id="user_password">
    
    
  <label for="user_password_confirmation">Confirm Password</label>
  <input class="form-input" type="password" name="password_confirmation" id="user_password_confirmation">
   
  <!-- left column -->
	<h6>Choose profile picture</h6>
	<input class="form-input" type="file" name="pic" id="user_pic">
  
    <input type="submit" name="create" value="Create My Account" class="button">
</form>
</div>
</div>
</body>
</html>