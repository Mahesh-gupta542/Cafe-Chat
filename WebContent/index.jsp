<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>CafeChat</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/ajax-js.js"></script>
</head>
<body >

<nav class="navbar">
<ul>
  <li><a class="active" style="font-family: cursive;"  href="#home">Cafe-Chat</a></li>
  <li style="float:right; font-size: -webkit-xxx-large;"><a  id="login">Login</a></li>
</ul>
</nav>
<div class="content"></div>

 <div id="loginbox" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
  <div class="modal-header">
  <div id="error"></div>
  <span class="close">X</span>
      <h2>Login</h2>
    </div>
    <div class="modal-body">
      <p>Username/Email-Id: <input type="text" id="userid" name="email" /></p>
	  <p>Password: <input type="password" id="password" name ="password"/></p>
	  <p><button id="submit" name="create" value="login">Submit </button></p>
	  
</div>
</div>
</div>
<div class="container">
<div class="jumbotron">
Welcome to the Cafe-Chat! <br>
Meet and chat with new people over a drink at ypur local bars or cafes.<br>
Find a chatup point near you or create one.
<a class="button" href="User?login=0">Sign up</a>

</div>
</div>

<script src="js/script.js"></script>

</body>
</html>