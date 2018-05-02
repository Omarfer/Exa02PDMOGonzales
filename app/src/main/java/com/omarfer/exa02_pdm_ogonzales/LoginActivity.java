package com.omarfer.exa02_pdm_ogonzales;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText InputEmail, clave;
    private Button logear;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private TextView Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);

        InputEmail = findViewById(R.id.email);
        clave = findViewById(R.id.password);
        logear = findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar);
        Reset = findViewById(R.id.forgotAccount);

        auth = FirebaseAuth.getInstance();//test

        Reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });

        logear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            String email = InputEmail.getText().toString();
            final String pass = clave.getText().toString();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Ingresar Usuario!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(getApplicationContext(), "Ingresar password!", Toast.LENGTH_SHORT).show();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            auth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (!task.isSuccessful()) {
                                if (pass.length() < 6) {
                                    Toast.makeText(LoginActivity.this, getString(R.string.minimum_password), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
            });
    }
}