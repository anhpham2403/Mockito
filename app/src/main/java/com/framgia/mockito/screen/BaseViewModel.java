package com.framgia.mockito.screen;

/**
 * Created by anh on 19/09/2017.
 */

/**
 * BaseView
 * @param <T> this is type paremeter
 */
public interface BaseViewModel<T extends BasePresenter> {

    void onStart();

    void onStop();

    void setPresenter(T presenter);
}
