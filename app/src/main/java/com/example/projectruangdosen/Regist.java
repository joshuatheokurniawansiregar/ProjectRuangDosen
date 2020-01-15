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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Regist extends AppCompatActivity {

    Button reg, log;
    TextView home;
    EditText email, name, password, tanggallahir,notelp;
    DatabaseReference ref;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        mAuth =FirebaseAuth.getInstance();

        ref = FirebaseDatabase.getInstance().getReference().child("User");
        email = (EditText) findViewById(R.id.email);
        name = (EditText)findViewById(R.id.Nama);
        password = (EditText)findViewById(R.id.password);
        tanggallahir = (EditText)findViewById(R.id.tgllahir);
        notelp = (EditText)findViewById(R.id.notelp);

        home = findViewById(R.id.btnHome);
        reg= findViewById(R.id.btnRegist_regist);
        log = findViewById(R.id.btnlogin_regist);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Regist.this, MainActivity.class);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Regist.this, Login.class);
                startActivity(intent);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email_s = email.getText().toString();
                String passsword_s = password.getText().toString();


                mAuth.createUserWithEmailAndPassword(email_s, passsword_s).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            String nama_s = name.getText().toString();
                            String email_s = email.getText().toString();
                            String passsword_s = password.getText().toString();
                            String tanggallahir_s = tanggallahir.getText().toString();
                            String notelp_s =notelp.getText().toString();

                            String key = ref.push().getKey();
                            User user = new User(nama_s, email_s, passsword_s, tanggallahir_s, notelp_s);
                            ref.child(key).setValue(user);
                            Toast.makeText(Regist.this, "Registration Success", Toast.LENGTH_SHORT).show();
                            ShredPreference.setRegisteredEmail(email_s, Regist.this);
                            Intent itent = new Intent(Regist.this, Login.class);
                            startActivity(itent);
                            finish();
                        }else{
                            Toast.makeText(Regist.this, "Registration Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
