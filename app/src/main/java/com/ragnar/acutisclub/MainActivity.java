package com.ragnar.acutisclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.google.firebase.auth.FirebaseUser;
import com.ragnar.acutisclub.Backend.PerformLogin;
import com.ragnar.acutisclub.Callbacks.SuccessFailureCallback;

public class MainActivity extends AppCompatActivity {
    TextView forgetPassword, loginButton, signUpButton;
    EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting the status bar to black
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        loginButton = findViewById(R.id.loginButton);
        forgetPassword = findViewById(R.id.forgetPasswordButton);
        signUpButton = findViewById(R.id.signUpButton);



        //to make an alert box to contact admin
        forgetPassword.setOnClickListener(view -> setForgetPassword());


        loginButton.setOnClickListener(view -> {

            String emailString = emailEditText.getText().toString();
            String passwordString = passwordEditText.getText().toString();

            PerformLogin performLogin = new PerformLogin();

            if(emailString.isEmpty() || passwordString.isEmpty()){
                Toast.makeText(this, "Fill both the fields", Toast.LENGTH_SHORT).show();

            }
            else {
                performLogin.login(emailString, passwordString, new SuccessFailureCallback() {
                    @Override
                    public void onSuccess(FirebaseUser user) {

                        Toast.makeText(MainActivity.this, "Login successful! Welcome ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, LoadFragments.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signUpButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }

    void setForgetPassword(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Forget Password");
        builder.setMessage("Contact the admin of Club");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}