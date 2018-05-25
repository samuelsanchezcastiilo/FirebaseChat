package sanchez.samuel.developer.androidchat;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;


public class AndroidChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
}

