package com.framgia.mockito.screen.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.mockito.R;
import com.framgia.mockito.databinding.ActivityHomeBinding;
import com.framgia.mockito.screen.BaseActivity;

/**
 * Home Screen.
 */
public class HomeActivity extends BaseActivity {

    private HomeContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new HomeViewModel();

        HomeContract.Presenter presenter = new HomePresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setViewModel((HomeViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
