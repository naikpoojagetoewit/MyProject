import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import csccorner.DatabaseDao;

public class RegisterDao {

    
    public String insert(Member member, String college, String branch, String address) {
        String result = "Data inserted successfully";
        DatabaseDao databaseDao = new DatabaseDao();

       
        if (isEmailExists(member.getEmail())) {
            return "Email already exists.";
        }

       
        String sqlMember = "INSERT INTO member (uname, password, email, phone) VALUES (?, ?, ?, ?)";
       
        String sqlMember2 = "INSERT INTO member2 (email, college, branch, address) VALUES (?, ?, ?, ?)";

        try (Connection con = databaseDao.getConnection()) {
            
            con.setAutoCommit(false);

           
            try (PreparedStatement psMember = con.prepareStatement(sqlMember)) {
                psMember.setString(1, member.getUname());
                psMember.setString(2, member.getPassword());
                psMember.setString(3, member.getEmail());
                psMember.setString(4, member.getPhone());
                psMember.executeUpdate();
            }

            
            try (PreparedStatement psMember2 = con.prepareStatement(sqlMember2)) {
                psMember2.setString(1, member.getEmail());  
                psMember2.setString(2, college);
                psMember2.setString(3, branch);
                psMember2.setString(4, address);
                psMember2.executeUpdate();
            }

           
            con.commit();
            
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data not entered: " + e.getMessage(); 
        }
        
        return result;
    }

    
    private boolean isEmailExists(String email) {
        String query = "SELECT 1 FROM member WHERE email = ?";
        try (Connection con = new DatabaseDao().getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  
    }


	public String insert(String uname1, String password1, String email11, String phone1, String college, String branch,
			String address) {
		// TODO Auto-generated method stub
		return null;
	}
}
