package login;

public class LoginForm {
    public boolean login(User user) {
        System.out.println("Hello, " + user.getName());
        return true;
    }
    public boolean logout(User user){
        System.out.println("Bye, "+ user.getName());
        return true;
    }
}