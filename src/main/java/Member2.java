public class Member2 {
    private String email;  
    private String college;
    private String branch;
    private String address;

    
    public Member2(String email, String college, String branch, String address) {
        this.email = email;
        this.college = college;
        this.branch = branch;
        this.address = address;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


