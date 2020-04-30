package com.example.movies2020.coremvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movies2020.customview.LoadingView;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    private View rootView;

    protected T mPresenter;

    private LoadingView loadingView;

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract T initPresenter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = initPresenter();
        mPresenter.attachView(this);

        loadingView = new LoadingView(getContext());

        init();
    }

    protected abstract void init();

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showLoading() {
        loadingView.show();
    }

    @Override
    public void dismiissLoading() {
        loadingView.cancel();
    }
}
