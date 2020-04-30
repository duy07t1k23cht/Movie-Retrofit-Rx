package com.example.movies2020.coremvp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movies2020.customview.LoadingView;


public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected T mPresenter;

    private LoadingView loadingView;

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract T initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mPresenter = initPresenter();
        mPresenter.attachView(this);

        loadingView = new LoadingView(this);

        setStatusBarDrawable();

        init();
    }

    protected abstract void init();

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        loadingView.show();
    }

    @Override
    public void dismiissLoading() {
        loadingView.cancel();
    }

    @Nullable
    protected Drawable overrideStatusBar() {
        return null;
    }

    private void setStatusBarDrawable() {
        Drawable background = overrideStatusBar();
        if (background == null) {
            return;
        }
        Window window = getWindow();
        int navigationColor = window.getNavigationBarColor();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
        window.setBackgroundDrawable(background);
        window.setNavigationBarColor(navigationColor);
    }
}
