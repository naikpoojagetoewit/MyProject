
public class Member {
    
	private String uname;
    private String password;
    private String email;
    private String phone;
    

    public Member(String uname, String password, String email, String phone) {
        this.uname = uname;
        this.password = password;
        this.email = email;
      
    }

    
    public Member() {
		// TODO Auto-generated constructor stub
	}


	public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
     
        
        
        
        
    }

