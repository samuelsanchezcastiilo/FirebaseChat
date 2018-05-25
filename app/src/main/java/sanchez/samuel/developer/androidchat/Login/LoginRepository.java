package sanchez.samuel.developer.androidchat.Login;

public interface LoginRepository {
    void signUp(String email,String password);
    void signIn(String email,String password);
    void checkSession();
}
