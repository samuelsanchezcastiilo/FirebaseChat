package sanchez.samuel.developer.androidchat.Login;

public class LoginIteratorImpl implements LoginInterator  {
    private LoginRepository loginRepository;

    public LoginIteratorImpl() {
        loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkSession() {
        loginRepository.checkSession();
    }

    @Override
    public void doSignUp(String email, String password) {
    loginRepository.signUp(email,password);
    }

    @Override
    public void doSignIn(String email, String password) {
    loginRepository.signIn(email,password);
    }
}
