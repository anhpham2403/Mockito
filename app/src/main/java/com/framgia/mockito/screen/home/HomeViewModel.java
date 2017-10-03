package com.framgia.mockito.screen.home;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.mockito.data.model.User;
import com.framgia.mockito.BR;
/**
 * Exposes the data to be used in the Home screen.
 */

public class HomeViewModel extends BaseObservable implements HomeContract.ViewModel {

    private HomeContract.Presenter mPresenter;
    private Context mContext;
    private String mUserName;
    private String mPassword;

    public HomeViewModel(Context context) {
        mContext = context;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoginSuccess(User user) {
        Toast.makeText(mContext, user.getUserName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Bindable
    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
        notifyPropertyChanged(BR.password);
    }

    public void onLoginClick() {
        mPresenter.login(mUserName, mPassword);
    }
}
