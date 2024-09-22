package com.ragnar.acutisclub.Callbacks;

import com.google.firebase.auth.FirebaseUser;

public interface SuccessFailureCallback {
    public void onSuccess(FirebaseUser user);
    public void onFailure(String message);
}
