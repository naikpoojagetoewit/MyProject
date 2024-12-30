 import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String college = request.getParameter("college");
        String branch = request.getParameter("branch");
        String address = request.getParameter("address");

       
        if (uname == null || password == null || email == null || phone == null || college == null || branch == null || address == null ||
            uname.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty() || college.isEmpty() || branch.isEmpty() || address.isEmpty()) {
            response.getWriter().print("Error: All fields are required.");
            return;
        }

       
        Member member = new Member();
        member.setUname(uname);
        member.setPassword(password);
        member.setEmail(email);
        member.setPhone(phone);

        
        RegisterDao rDao = new RegisterDao();

       
        String result = rDao.insert(member, college, branch, address);

        
        if ("Data inserted successfully".equals(result)) {
            
            request.setAttribute("uname", uname);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("college", college);
            request.setAttribute("branch", branch);
            request.setAttribute("address", address);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
            rd.forward(request, response);
        } else {
            
            response.getWriter().print("Error: " + result);
        }
    }
}
