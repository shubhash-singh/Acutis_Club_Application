package com.ragnar.acutisclub;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseUser;
import com.ragnar.acutisclub.Backend.PerformSignUp;
import com.ragnar.acutisclub.Callbacks.SuccessFailureCallback;

public class SignUpActivity extends AppCompatActivity {
    EditText nameEditText, rollNoEditText, phoneEditText,emailEditText, passwordEditText;
    EditText leetCodeEditText, hackerRankEditText, gitHubEditText;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Setting the status bar to black
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));


        PerformSignUp performRegistration = new PerformSignUp();


        nameEditText = findViewById(R.id.nameEditText);
        rollNoEditText = findViewById(R.id.rollNoEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        leetCodeEditText = findViewById(R.id.leetcodeEditText);
        hackerRankEditText = findViewById(R.id.hackerrankEditText);
        gitHubEditText = findViewById(R.id.githubEditText);

        signUp = findViewById(R.id.registerButton);

        signUp.setOnClickListener(view -> {
            String name = nameEditText.getText().toString().trim();
            String rollNo = rollNoEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String leetCodeLink = leetCodeEditText.getText().toString().trim();
            String hackerRankLink = hackerRankEditText.getText().toString().trim();
            String githubLink = gitHubEditText.getText().toString().trim();

            performRegistration.registerUser(name, rollNo, phone, email, password,leetCodeLink, hackerRankLink, githubLink, new SuccessFailureCallback() {
                @Override
                public void onSuccess(FirebaseUser user) {
                    // Handle success - registration successful, user created and data stored in Firestore
                    Toast.makeText(SignUpActivity.this, "Registration successful! Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();
                    // Proceed to another activity or dashboard
                }

                @Override
                public void onFailure(String errorMessage) {
                    // Handle failure - registration or Firestore failed
                    Toast.makeText(SignUpActivity.this, "Registration failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                }
            });
        });


    }
}