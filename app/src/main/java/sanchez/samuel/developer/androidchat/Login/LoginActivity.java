package sanchez.samuel.developer.androidchat.Login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sanchez.samuel.developer.androidchat.ContactListActivivy;
import sanchez.samuel.developer.androidchat.R;


public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.editText_email)
    EditText inputEmail;
    @BindView(R.id.editText_password)
    EditText passWord;
    private static final String TAG = "LoginActivity";
    @BindView(R.id.button_action_signin)
    Button signIn;
    @BindView(R.id.button_action_signup)
    Button signUn;
    @BindView(R.id.progres_login)
    ProgressBar progressBar;
    @BindView(R.id.container)
    RelativeLayout container;



private  LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this);



    }
    @OnClick({R.id.button_action_signin})
    public void handleSignin(){
        Log.e(TAG, "handleSignin: " + inputEmail.getText().toString());
    }


    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);


    }
@OnClick(R.id.button_action_signin)
    @Override
    public void handleSingUp() {
    loginPresenter.registerNewUser(inputEmail.getText().toString(),
                                passWord.getText().toString());
    }

    @Override
    public void handleSingIn() {
        loginPresenter.validateLoginUser(inputEmail.getText().toString(),
                                        passWord.getText().toString());


    }

    @Override
    public void navigateToMainScreen(){
        startActivity(new Intent(this, ContactListActivivy.class));

    }

    @Override
    public void loginError(String error) {
        passWord.setText("");
        String msgError = String.format(getString(R.string.login_mesagge_error_sigup),error);
        passWord.setError(msgError);


    }

    @Override
    public void newUserSucces() {
        Snackbar.make(container,R.string.login_notice_mesasage_sigup,Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void newUserError(String error) {

    }

    private void setInputs(boolean enable){
        inputEmail.setEnabled(enable);
        passWord.setEnabled(enable);
        signIn.setEnabled(enable);
        signUn.setEnabled(enable);


    }
}
