package com.framgia.mockito.data.source;

import com.framgia.mockito.data.model.User;

/**
 * Created by workspace on 11/09/2017.
 */

public class UserRepository implements UserDataSource {
    private UserDataSource mLocalDataSource;

    public UserRepository(UserDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    @Override
    public void login(String userName, String password, Callback<User> callback) {
        mLocalDataSource.login(userName, password, callback);
    }
}
