package com.example.projectruangdosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class AccountData extends AppCompatActivity {

    private TextView email_et;
    private EditText name_et;
    private EditText password_et;
    private EditText tgl_et;
    private EditText notelp_et;

    private Button update;
    private Button delete;
    private Button logout;

    private String key;
    private String email;
    private String name;
    private String password;
    private String tgl;
    private String notelp;

    TextView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_data);
        key = getIntent().getStringExtra("key");
        name = getIntent().getStringExtra("nama");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        tgl = getIntent().getStringExtra("tanggallahir");
        notelp = getIntent().getStringExtra("notelp");

        email_et = (TextView) findViewById(R.id.account_data_email);
        email_et.setText(email);
        name_et = (EditText) findViewById(R.id.account_data_name);
        name_et.setText(name);
        password_et = (EditText) findViewById(R.id.account_data_password);
        password_et.setText(password);
        tgl_et = (EditText) findViewById(R.id.account_data_tanggal);
        tgl_et.setText(tgl);
        notelp_et = (EditText) findViewById(R.id.account_data_notelp);
        notelp_et.setText(notelp);

        home = (TextView) findViewById(R.id.btnHome);

        update = (Button) findViewById(R.id.update_aja);
        delete = (Button) findViewById(R.id.delete_aja);
        logout = (Button) findViewById(R.id.logout_aja);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User users = new User();
                users.setEmail(email_et.getText().toString());
                users.setName(name_et.getText().toString());
                users.setPassword(password_et.getText().toString());
                users.setTanggallahir(tgl_et.getText().toString());
                users.setNotelp(notelp_et.getText().toString());

                new FirebaseDataHelper_User().updateBook(key, users, new FirebaseDataHelper_User.DataStatus() {
                    @Override
                    public void dataIsLoad(List<User> users, List<String> keys) {

                    }

                    @Override
                    public void dataIsUpdate() {
                        Toast.makeText(AccountData.this, "Data is updated", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void dataIsDeleted() {

                    }
                });

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(AccountData.this,"Data Delete",Toast.LENGTH_LONG).show();

                new FirebaseDataHelper_User().deleteBook(key, new FirebaseDataHelper_User.DataStatus() {
                    @Override
                    public void dataIsLoad(List<User> users, List<String> keys) {

                    }

                    @Override
                    public void dataIsUpdate() {

                    }

                    @Override
                    public void dataIsDeleted() {
                        Intent intent = new Intent(AccountData.this, Login.class);
                        startActivity(intent);
                        Toast.makeText(AccountData.this, "Data is Deleted", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
