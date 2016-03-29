<%-- 
    Document   : AmazonSignIn
    Created on : Mar 12, 2016, 3:55:52 PM
    Author     : Jacob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Walmart Easy Access Sign In Page</title>
        <link href="css/bootstrapStuff.css" rel="stylesheet">
        <link href="css/bootstrapSignIn.css" rel="stylesheet">
        <link href="css/other.css" rel="stylesheet">
    </head>
    <body>
        <h1 class="theBlue"><b>Walmart Easy Access</b></h1>
    <div class="container">

      <form class="form-signin" method="POST" action="Authenticate">
            
        <h3 style="text-align:center" class="form-signin-heading">Please Sign In</h3>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required><br />
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign In">
        <a href="createNewUser.jsp" class="btn btn-lg btn-primary btn-block">
            Create User</a>
      </form>

    </div> <!-- /container -->

  </body>
</html>