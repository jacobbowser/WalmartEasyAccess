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
        <title>Walmart Easy Access Create New User Page</title>
        <link href="css/bootstrapStuff.css" rel="stylesheet">
        <link href="css/bootstrapSignIn.css" rel="stylesheet">
    </head>
    <body>
        <h1 style="color:#337ab7;text-align:center"><b>Walmart Easy Access</b></h1>
    <div class="container">

      <form class="form-signin" method="POST" action="AddUser">
            
        <h3 style="text-align:center" class="form-signin-heading">Please Enter Your Information</h3>
        Username:<br />
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        <br />Password:<br />
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required><br />
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Create User">
      </form>

    </div> <!-- /container -->

  </body>
</html>