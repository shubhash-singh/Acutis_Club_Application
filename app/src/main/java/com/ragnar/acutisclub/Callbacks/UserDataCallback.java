package com.ragnar.acutisclub.Callbacks;

import java.util.List;

public interface UserDataCallback {
    public void onSuccess(List<String> userData);
    public void onFailure(String message);
}
