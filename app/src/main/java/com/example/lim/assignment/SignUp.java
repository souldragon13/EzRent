package com.example.lim.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    private TextView loginLink;
    private Button Signupbutton;
    EditText usernameEditText,emailEditText,passwordEditText;

    DatabaseReference databaseuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        databaseuser = FirebaseDatabase.getInstance().getReference("user");
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        loginLink = (TextView)findViewById(R.id.link_login);
        Signupbutton =(Button) findViewById(R.id.btn_signup);

        Signupbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               //signup();
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(username.equals("")||email.equals("")||password.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }else{
                    adduser();
                    Login();
//                        Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getApplicationContext(),"username Already exists",Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);

            }
        });
    }
    public void Login(){
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }
    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }
        Signupbutton.setEnabled(false);

    }
    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "SignIn failed", Toast.LENGTH_LONG).show();

        Signupbutton.setEnabled(true);
    }
    public boolean validate() {

         usernameEditText = (EditText) findViewById(R.id.usernameEditText);
         emailEditText = (EditText) findViewById(R.id.emailEditText);
         passwordEditText = (EditText) findViewById(R.id.passwordEditText);

       boolean valid = true;

        String username = usernameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();




        if (username.isEmpty() || username.length() > 8 ) {
            usernameEditText.setError("enter a valid username");
            valid = false;
        } else {
            usernameEditText.setError(null);
        }



        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("enter a valid email address");
            valid = false;
        } else {
            emailEditText.setError(null);
        }



        if (password.isEmpty() || password.length() > 8) {
            passwordEditText.setError("enter a valid password");
            valid = false;
        } else {
            passwordEditText.setError(null);
        }

        return valid;
    }
    private void adduser(){
        String name = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        String id = databaseuser.push().getKey();
        User user = new User(name,email,password);

        databaseuser.child(name).setValue(user);

        Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
    }
}
