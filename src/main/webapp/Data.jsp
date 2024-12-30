<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get data</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
<%@ page import="java.sql.*" %>
<%
ResultSet rs= null;
Connection con= null;
PreparedStatement ps = null;
String query = "select * from userdb.member";
try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","8008");
    ps = con.prepareStatement(query);
    rs = ps.executeQuery();
    while(rs.next()) {
%>
    <tr>
        <td><%= rs.getString("uname") %></td>
        <td><%= rs.getString("password") %></td>
        <td><%= rs.getString("email") %></td>
        <td><%= rs.getString("phone") %></td>
    </tr>
<%
    }
} catch(Exception e) {
    e.printStackTrace();
}
%>
</table>
</body>
</html>
