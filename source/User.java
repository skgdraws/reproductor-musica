/**
 * The class that stores User Data :3
 * 
 * @author Franco Sagot
 */
public class User {
    
    String fullName;
    String email;

    String province;
    String password;

    public User(String name, String email, String province, String password){

        this.fullName = name;
        this.email = email;

        this.province = province;
        this.password = password;
    }

    public String getUserName(){

        return this.fullName;
    }

    public String getPassword(){

        return this.password;
    }

    public Boolean checkPassword(String newPass){

        return newPass == this.password;
    }
}
