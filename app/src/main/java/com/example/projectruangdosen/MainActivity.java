package com.example.projectruangdosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    CardView m1, m2, l1, l2, s1, s2;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent takeEmail= getIntent();

        final TextView email_textView = (TextView)findViewById(R.id.getEmail);
        final TextView buttonAkun = (TextView)findViewById(R.id.btnAkun);
        final TextView buttonReport = (TextView)findViewById(R.id.btnReport);
        m1 = (CardView) findViewById(R.id.card_3_1);
        l1 = (CardView) findViewById(R.id.card_3_2);
        s1 = (CardView) findViewById(R.id.card_3_3);
        m2 = (CardView) findViewById(R.id.card_4_1);
        l2 = (CardView) findViewById(R.id.card_4_2);
        s2 = (CardView) findViewById(R.id.card_4_3);
        mAuth =FirebaseAuth.getInstance();
        if (ShredPreference.getRegisteredEmail(getBaseContext()) == null){
            startActivity(new Intent(MainActivity.this, Login.class));
            finish();

        }else{
            Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            String test = ShredPreference.getRegisteredEmail(getBaseContext());
            email_textView.setText(test);

        }
        FirebaseUser user = mAuth.getCurrentUser();
//        mAuthListener = new FirebaseAuth.AuthStateListener(){
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if(user !=null){
//                    Log.d("check", "onAuthStateChanged:signed_in" + user.getUid());
//                }else{
//                    startActivity(new Intent(MainActivity.this, Login.class));
//                }
//            }
//        };



        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, akuntansi_materi.class);
                startActivity(intent);
            }
        });

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, akuntansi_latihan.class);
                startActivity(intent);
            }
        });

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, akuntansi_soal.class);
                startActivity(intent);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, manajemen_materi.class);
                startActivity(intent);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, manajemen_latihan.class);
                startActivity(intent);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, manajemen_soal.class);
                startActivity(intent);
            }
        });

        buttonAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Account.class));
            }
        });
        buttonReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Report.class));
            }
        });
    }
    public String getContexts(){
        return ShredPreference.getRegisteredEmail(getBaseContext());
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (!ShredPreference.getLoggedInStatus(getBaseContext())){
//            startActivity(new Intent(MainActivity.this, Login.class));
//            finish();
//        }else{
//            Toast.makeText(MainActivity.this, "Congratulation", Toast.LENGTH_SHORT).show();
//        }
//    }
}
