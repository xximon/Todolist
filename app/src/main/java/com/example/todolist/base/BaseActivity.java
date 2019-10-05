package com.example.todolist.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {
    protected P mPresenter;
    protected abstract P setPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = setPresenter();
        mPresenter.setView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.removeView();
    }
}
