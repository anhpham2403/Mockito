package com.framgia.mockito.screen.home;

import com.framgia.mockito.data.model.User;
import com.framgia.mockito.data.source.UserDataSource;
import com.framgia.mockito.data.source.UserRepository;

/**
 * Listens to user actions from the UI ({@link HomeActivity}), retrieves the data and updates
 * the UI as required.
 */
public class HomePresenter implements HomeContract.Presenter {
    private final HomeContract.ViewModel mViewModel;
    UserRepository mRepository;

    public HomePresenter(HomeContract.ViewModel viewModel, UserRepository repository) {
        mViewModel = viewModel;
        mRepository = repository;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void login(String username, String password) {
        mRepository.login(username, password, new UserDataSource.Callback<User>() {
            @Override
            public void onSuccess(User data) {
                mViewModel.onLoginSuccess(data);
            }

            @Override
            public void onFailed(String message) {
                mViewModel.onLoginFailure(message);
            }
        });
    }
}
