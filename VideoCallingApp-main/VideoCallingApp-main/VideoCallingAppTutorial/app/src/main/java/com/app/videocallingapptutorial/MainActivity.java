package com.app.videocallingapptutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.app.videocallingapptutorial.activities.LoginActivity;
import com.app.videocallingapptutorial.activities.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void btnClickLogin() {
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnRegister)
    public void btnClickRegister() {
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}