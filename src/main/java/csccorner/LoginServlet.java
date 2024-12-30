package csccorner;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        response.setContentType("text/html");

        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String dbUrl = "jdbc:mysql://localhost:3306/userdb";  
            String dbUser = "root";  
            String dbPassword = "8008";  
            
            con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

   
            ps = con.prepareStatement("SELECT * FROM member WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);

        
            rs = ps.executeQuery();

           
            if (rs.next()) {
            	String uname = rs.getString("uname");
            	String email1 = rs.getString("email");
            	String phone = rs.getString("phone");
            	
            	request.setAttribute("uname",uname);
            	request.setAttribute("email",email1);
            	request.setAttribute("phone",phone);
            	
                
                RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
                rd.forward(request, response);
            } else {
              
                out.println("<font color=red size=18>Login Failed!!<br>");
                out.println("<a href='memberLogin.jsp'>Try AGAIN!!</a>");
            }

        } catch (SQLException e) {
            
            out.println("<font color=red size=18>Error: " + e.getMessage() + "</font>");
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {
            
            out.println("<font color=red size=18>Error: MySQL JDBC Driver not found.</font>");
            e.printStackTrace();  
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();  
            }
        }
    }
}
