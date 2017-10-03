package com.framgia.mockito.data.source;

import com.framgia.mockito.data.model.User;

/**
 * Created by workspace on 11/09/2017.
 */

public interface UserDataSource {

    void login(String userName, String password, Callback<User> callback);

    interface Callback<T> {
        void onSuccess(T data);

        void onFailed(String message);
    }
}
