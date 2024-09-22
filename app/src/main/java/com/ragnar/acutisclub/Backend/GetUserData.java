package com.ragnar.acutisclub.Backend;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ragnar.acutisclub.Callbacks.UserDataCallback;

import java.util.ArrayList;
import java.util.List;

public class GetUserData {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    public GetUserData(){
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    public void getNameRollNo(UserDataCallback callback){
        FirebaseUser user = mAuth.getCurrentUser();

        assert user != null;
        DocumentReference docRef = db.collection("users").document(user.getUid());
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document != null && document.exists()) {
                    // Document found
                    List<String> userData = new ArrayList<>();
                    userData.add(document.getString("name"));
                    userData.add(document.getString("rollNo"));
//                    userData.add(document.getString("phone"));
//                    userData.add(document.getString("email"));

                    callback.onSuccess(userData);
                } else {
                    callback.onFailure("UID not found");
                }
            } else {
                callback.onFailure(task.getException().toString());
            }
        });
    }
}
