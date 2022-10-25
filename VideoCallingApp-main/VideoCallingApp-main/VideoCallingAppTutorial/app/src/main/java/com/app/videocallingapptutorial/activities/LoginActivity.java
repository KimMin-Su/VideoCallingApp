package com.app.videocallingapptutorial.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.videocallingapptutorial.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edEmail) TextInputEditText edEmail;
    @BindView(R.id.edPassword) TextInputEditText edPassword;
    @BindView(R.id.progressBarLogin) ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        auth=FirebaseAuth.getInstance();
    }

    @OnClick(R.id.goBack)
    public void btnClickGoBack() {
        finish();
    }
    @OnClick(R.id.btnLogin)
    public void btnClickLogin() {
        String txt_email=edEmail.getText().toString();
        String txt_password=edPassword.getText().toString();

        if (TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)) {
            Toast.makeText(this, "Email & password cannot be empty", Toast.LENGTH_LONG).show();
        }
        if (txt_password.length()<6) {
            Toast.makeText(this, "Password length should be 6 characters or long", Toast.LENGTH_LONG).show();
            return;
        }

        loginUser(txt_email,txt_password);
    }
    private void loginUser(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);

        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Intent intent=new Intent(LoginActivity.this, HomeScreenActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Incorrect email/password",
                                    Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

}