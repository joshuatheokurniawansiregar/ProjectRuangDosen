package com.example.projectruangdosen;
//Modif
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Account extends AppCompatActivity {

    TextView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        home = findViewById(R.id.btnHome);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView_account);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this, MainActivity.class);
                startActivity(intent);
            }
        });

        new FirebaseDataHelper_User().readAccount(new FirebaseDataHelper_User.DataStatus() {
            @Override
            public void dataIsLoad(List<User> users, List<String> keys) {
                new RecyclerView_Config_Account().setConfig(recyclerView, Account.this, users, keys);
            }

            @Override
            public void dataIsUpdate() {

            }

            @Override
            public void dataIsDeleted() {

            }
        });
    }
}
