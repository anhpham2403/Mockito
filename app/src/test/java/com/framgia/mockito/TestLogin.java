package com.framgia.mockito;

import com.framgia.mockito.data.model.User;
import com.framgia.mockito.data.source.UserDataSource;
import com.framgia.mockito.data.source.UserRepository;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by anh on 03/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestLogin {
    @Mock
    private UserRepository mRepository;

    @Test
    public void testLogin() {
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                UserDataSource.Callback callback =
                        (UserDataSource.Callback) invocation.getArguments()[2];
                callback.onSuccess(new User(new Random().nextInt(), "abcdef", "123456"));
                return null;
            }
        }).when(mRepository).login(anyString(), anyString(), any(UserDataSource.Callback.class));
        String userName = "abcdef";
        String password = "123456";
        mRepository.login(userName, password, new UserDataSource.Callback<User>() {
            @Override
            public void onSuccess(User data) {
                assertEquals(data.getUserName(), "abcdef");
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }
}


