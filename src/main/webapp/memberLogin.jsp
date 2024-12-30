<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <form action="LoginServlet" method="post">
   <table>
   <tr><td>Enter Email:</td><td><input type=Email name="txtEmail"></td></tr>
   <tr><td>Enter Password:</td><td><input type=password name=txtPassword></td></tr>
   <tr><td><input type=submit value=Login></td><td><input type=reset></td></tr>
				<tr><td><a href="memberRegister.jsp"> Register Here</a></td>
				
			</tr>
			
   </table>
    </form>
    
</body>
</html>