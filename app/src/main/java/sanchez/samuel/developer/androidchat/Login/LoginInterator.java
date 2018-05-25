package sanchez.samuel.developer.androidchat.Login;

public interface LoginInterator {
    void checkSession();
    void doSignUp(String email,String password);
    void doSignIn(String email,String password);

}
