package com.framgia.mockito.screen.home;

import com.framgia.mockito.screen.BasePresenter;
import com.framgia.mockito.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface HomeContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
