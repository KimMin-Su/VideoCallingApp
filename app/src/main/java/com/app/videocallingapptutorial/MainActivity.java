package com.app.videocallingapptutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.btnLogin)
    public void btnClickLogin() {

    }

    @OnClick(R.id.btnRegister)
    public void btnClickRegister() {
        
    }
}