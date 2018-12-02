package login;

public class MyTwitterUser implements User{
    private TwitterUser tuser;
    public MyTwitterUser(TwitterUser fuser){
        this.tuser = fuser;
    }
    @Override
    public String getName() {
        return tuser.getName() + " " + tuser.getSurname();
    }

    @Override
    public String getEmail() {
        return tuser.getAddress();
    }

    @Override
    public String getPhone() {
        return tuser.getNumber();
    }
}