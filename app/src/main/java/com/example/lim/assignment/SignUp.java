package com.example.lim.assignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    private TextView loginLink;
    private Button Signupbutton;
    EditText usernameEditText,emailEditText,passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        loginLink = (TextView)findViewById(R.id.link_login);
        Signupbutton =(Button) findViewById(R.id.btn_signup);

        Signupbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });
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
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

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
            usernameEditText.setError("Enter a valid username");
            valid = false;
        } else {
            usernameEditText.setError(null);
        }



        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Enter a valid email address");
            valid = false;
        } else {
            emailEditText.setError(null);
        }



        if (password.isEmpty() || password.length() > 8) {
            passwordEditText.setError("Enter a valid password");
            valid = false;
        } else {
            passwordEditText.setError(null);
        }

        return valid;
    }
}
