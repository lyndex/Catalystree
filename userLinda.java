public class User {

    private int id;
    private String email;
    private String username;
    private String password;

    public User() {

    }

    public User(int id, String email, String username, String password)
    {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User (String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

}
