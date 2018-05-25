package sanchez.samuel.developer.androidchat.Login;

public interface LoginPresenter {
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLoginUser(String email, String password);
    void registerNewUser(String email, String password);
}
