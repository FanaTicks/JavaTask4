package authorization.pack;

public class Acount {
    public String login;
    public String password;
    public String name;
    public Acount(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }

}
