package login;

public class MyGoogleUser implements User{
    private GoogleUser guser;
    public MyGoogleUser(GoogleUser guser){
        this.guser = guser;
    }
    @Override
    public String getName() {
        return guser.getUsername();
    }

    @Override
    public String getEmail() {
        return guser.getMail();
    }

    @Override
    public String getPhone() {
        return guser.getMobilephone();
    }
}