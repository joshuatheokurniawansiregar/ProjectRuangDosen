package com.example.projectruangdosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button reg, log;
    TextView home;

    EditText email;
    EditText password;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth= FirebaseAuth.getInstance();
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        home = (TextView) findViewById(R.id.btnHome);
        reg = (Button) findViewById(R.id.btnRegist_login);
        log = (Button) findViewById(R.id.btnlogin_login);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Regist.class);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emails= email.getText().toString();
                String passwords = password.getText().toString();
                mAuth.signInWithEmailAndPassword(emails, passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent prosusIntent = new Intent(Login.this, MainActivity.class);
                            prosusIntent.putExtra("email", emails);
                            ShredPreference.setRegisteredEmail(emails, getBaseContext());
                            startActivity(prosusIntent);
                            finish();
                        }else{
                            Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG);
                        }
                    }
                });
            }
        });
    }
}
