package com.ragnar.acutisclub.Backend;


import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import com.ragnar.acutisclub.Callbacks.SuccessFailureCallback;

import java.util.HashMap;
import java.util.Map;
public class PerformSignUp {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    public PerformSignUp() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }
    public void registerUser(String name, String rollNo, String phone, String email, String password,String leetCodeLink,String hackerRankLink, String githubLink, SuccessFailureCallback callback) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();

                            Map<String, Object> userData = new HashMap<>();
                            userData.put("name", name);
                            userData.put("rollNo", rollNo);
                            userData.put("phone", phone);
                            userData.put("email", email);
                            userData.put("leetCodeLink", leetCodeLink);
                            userData.put("hackerRankLink", hackerRankLink);
                            userData.put("githubLink", githubLink);


                            // Store user data in Firestore under "users" collection, document is user's UID
                            db.collection("users")
                                    .document(user.getUid())
                                    .set(userData)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> firestoreTask) {
                                            if (firestoreTask.isSuccessful()) {
                                                callback.onSuccess(user);
                                            } else {
                                                callback.onFailure(firestoreTask.getException().getMessage());
                                            }
                                        }
                                    });
                        } else {
                            // Registration failed
                            callback.onFailure(task.getException().getMessage());
                        }
                    }
                });
    }
}
