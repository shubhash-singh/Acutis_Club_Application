package com.ragnar.acutisclub.Backend;

import androidx.annotation.NonNull;

import com.google.firebase.auth.AuthResult;
import com.ragnar.acutisclub.Callbacks.SuccessFailureCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class PerformLogin {
    private FirebaseAuth mAuth;

    public PerformLogin(){
        mAuth = mAuth = FirebaseAuth.getInstance();
    }

    public void login(String email, String password, SuccessFailureCallback callback){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // On successful login
                            FirebaseUser user = mAuth.getCurrentUser();
                            assert user != null;
                            callback.onSuccess(user);
                        } else {
                            // On login failure
                            task.getException().printStackTrace();
                            String errorMessage = task.getException() != null ? task.getException().getMessage() : "Login failed.";
                            callback.onFailure(errorMessage);
                        }
                    }
                });
    }
}
