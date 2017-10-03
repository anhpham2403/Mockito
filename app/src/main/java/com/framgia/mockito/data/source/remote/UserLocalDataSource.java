package com.framgia.mockito.data.source.remote;

import com.framgia.mockito.data.model.User;
import com.framgia.mockito.data.source.UserDataSource;
import java.util.Random;

/**
 * Created by workspace on 11/09/2017.
 */

public class UserLocalDataSource implements UserDataSource {

    public UserLocalDataSource() {
    }

    @Override
    public void login(String userName, String password, Callback<User> callback) {
        if (userName.equalsIgnoreCase("abcdef") && password.equalsIgnoreCase("123456")) {
            callback.onSuccess(new User(new Random().nextInt(), userName, password));
        } else {
            callback.onFailed("Error!");
        }
    }
}
