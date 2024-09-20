package com.ragnar.acutisclub.Backend;

import com.ragnar.acutisclub.Callbacks.SuccessFailureCallback;

public class PerformSignUp {

    public void sendSignupRequest(String name, String email, String password, SuccessFailureCallback callback){
        callback.onSuccess("Successful");
    }
}
