package sanchez.samuel.developer.androidchat.Login;

public class LoginPresenterImpl implements LoginPresenter {
    LoginView loginView;
    LoginInterator loginInterator;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onDestroy() {
        loginView = null;

    }

    @Override
    public void checkForAuthenticatedUser() {
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInterator.checkSession();

    }

    @Override
    public void validateLoginUser(String email, String password) {
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInterator.doSignIn(email,password);


    }

    @Override
    public void registerNewUser(String email, String password) {

        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInterator.doSignUp(email,password);


    }

    private void onSignInSucces(){
        if(loginView != null){
            loginView.navigateToMainScreen();
        }

    }
    private void onSignUpSucces(){
        if (loginView!= null){
            loginView.newUserSucces();
        }

    }
    private void onSignInError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }

    }
    private void onSignUpError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}
