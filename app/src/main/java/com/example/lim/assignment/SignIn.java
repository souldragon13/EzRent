package com.example.lim.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private TextView signupLink;
    private Button Loginbutton;
    EditText usernameEditText,passwordEditText;
    private DatabaseReference databaseuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //databaseuser = FirebaseDatabase.getInstance().getReference("user");
        databaseuser = FirebaseDatabase.getInstance().getReference().child("user");
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        Loginbutton = (Button)findViewById(R.id.btn_login);
        signupLink = (TextView)findViewById(R.id.link_signup);

        Loginbutton.setOnClickListener(new View.OnClickListener() {
            String password;
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                password = passwordEditText.getText().toString().trim();
                databaseuser.child(username).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);


                        if(password.equals(user.getPassword())){
                            Toast.makeText(getApplicationContext(), "SignIn Successfully", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(SignIn.this, Homepage.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Pls Enter Password!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });
    }

    public void login() {
        Log.d(TAG, "SignIn");
        if (!validate()) {
            onLoginFailed();
            return;
        }

        Loginbutton.setEnabled(false);

    }


    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "SignUp failed", Toast.LENGTH_LONG).show();

        Loginbutton.setEnabled(true);
    }

    public boolean validate() {

        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);

        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        boolean valid = true;

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (username.isEmpty() ||username.length()<4|| username.length() > 10 ) {
            usernameEditText.setError("enter a valid username");
            valid = false;
        } else {
            usernameEditText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordEditText.setError("enter a valid password");
            valid = false;
        } else {
            passwordEditText.setError(null);
        }

        return valid;
    }

//    private void SignIn(final String username,final String password){
//        databaseuser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.child(username).exists()) {
//                    if (!username.isEmpty()) {
//                        User login = dataSnapshot.child(username).getValue(User.class);
//                        if (login.getPassword().equals(password)) {
//                            Toast.makeText(getApplicationContext(), "SignIn Successfully", Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Wrong Password!", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Username is Not Exist!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
}
