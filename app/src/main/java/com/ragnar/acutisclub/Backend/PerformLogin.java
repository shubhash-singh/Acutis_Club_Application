package com.ragnar.acutisclub.Backend;

import com.ragnar.acutisclub.Callbacks.SuccessFailureCallback;

public class PerformLogin {
    public PerformLogin(){

    }

    public void login(String email, String password, SuccessFailureCallback callback){
        callback.onSuccess("Callback");
    }
}
