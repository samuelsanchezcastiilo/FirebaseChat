package sanchez.samuel.developer.androidchat.Domain;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHelper {
    private DatabaseReference  database;
    private FirebaseAuth auth;

    private final static String SEPARATOR = "____";
    private final static String CHAT_PATH = "chats";
    private final static String USERS_PATH = "users";
    private final static String CONTACTS_PATH = "contacts";
    private final static String FIRBASE_URL = "https://chat-9518f.firebaseio.com/\n";

    private static  class SingletonHolder{
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public FirebaseHelper() {
        database = FirebaseDatabase.getInstance().getReference();

    }

    public DatabaseReference getDatabase() {
        return database;
    }
    public String getAuthUserEmail(){
        auth = FirebaseAuth.getInstance();

        return null;
    }

    public FirebaseDatabase getUSerReferences(String email){
        DatabaseReference userReference = null;
        if (email != null){
            String emailkey = email.replace(".","_");
           /// usserReference = FirebaseAuth.getInstance().addAuthStateListener(email).getRoot().child(USERS_PATH).child(emailkey);
        }
        return  null;
    }
    public FirebaseDatabase getMyUserReference(){

        return getUSerReferences(getAuthUserEmail());
    }

    public DatabaseReference getContactsReference(String email){
        return  getUSerReferences(email).getReference().child(CONTACTS_PATH);

    }

    public  DatabaseReference getMyContactUserReference(){
        return getContactsReference(getAuthUserEmail());
    }
    public DatabaseReference getOneContactReferences(String mainEmail,String childEmail){
        String childkey = childEmail.replace(".","_");
    return getUSerReferences(mainEmail).getReference().child(CONTACTS_PATH).child(childkey);

    }
    public DatabaseReference getChatReference(String receiver){
        String keySender = getAuthUserEmail().replace(".","_");
        String keyReceiver = receiver.replace(".","_");
         String keyChat = keySender + SEPARATOR + keyReceiver;

        if (keySender.compareTo(keyReceiver) > 0){
             keyChat = keyReceiver + SEPARATOR + keySender;

        }
         return database.getRoot().child(CHAT_PATH).child(keyChat);

    }

    public void changeUserConnectionsStatus(boolean online){
        if (getMyUserReference() != null){
            Map<String,Object> updates =  new HashMap<String, Object>();
            updates.put("online",online);
            //etMyUserReference().updateChildren(updates);
            notifyContactsConnectionChange(online);
        }


    }
    public void notifyContactsConnectionChange(boolean online){
        notifyContactsConnectionChange(online,false);
    }
    public void signOff(){
        notifyContactsConnectionChange(false,true);
    }

    private void notifyContactsConnectionChange(final boolean online, final boolean signoff){
        final String myemail = getAuthUserEmail();
        getMyContactUserReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()){
                    String email = child.getKey();
                    DatabaseReference reference = getOneContactReferences(email,myemail);
                    reference.setValue(online);

                }

                if (signoff){
                    //database.unauth();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
