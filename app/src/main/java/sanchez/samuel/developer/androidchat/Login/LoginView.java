package sanchez.samuel.developer.androidchat.Login;

public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSingUp();
    void handleSingIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSucces();
    void newUserError(String error);

}
