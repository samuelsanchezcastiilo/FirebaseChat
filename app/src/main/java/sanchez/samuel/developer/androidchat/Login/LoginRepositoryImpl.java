package sanchez.samuel.developer.androidchat.Login;

import android.util.Log;

import sanchez.samuel.developer.androidchat.Domain.FirebaseHelper;

public class LoginRepositoryImpl implements  LoginRepository{
   private FirebaseHelper firebaseHelper;
 private static final String TAG = "LoginRepositoryImpl";

    public LoginRepositoryImpl() {
        this.firebaseHelper = FirebaseHelper.getIntance();
    }

    @Override
    public void signUp(String email, String password) {

     Log.e(TAG, "signUp: ");

    }

    @Override
    public void signIn(String email, String password) {
     Log.e(TAG, "signIn: " );
    }

    @Override
    public void checkSession() {
     Log.e(TAG, "checkSession: ");

    }
}
