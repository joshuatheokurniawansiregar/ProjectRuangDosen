package com.example.projectruangdosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class manajemen_soal extends AppCompatActivity {

    Button sel_soalman, lat_man;
    TextView home;
    int correct=0, marks=0, wrong=0, blank=0;
    int flag = 0;
    int ifcorect = 10;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manajemen_soal);

        final TextView emailPengguna= (TextView)findViewById(R.id.emailPengguna_soalman);

        ref = FirebaseDatabase.getInstance().getReference().child("Report");
        final RadioButton sdf1 = (RadioButton)findViewById(R.id.jawab1_4_soalman);
        final RadioButton sdf2 = (RadioButton)findViewById(R.id.jawab2_3_soalman);
        final RadioButton sdf3 = (RadioButton)findViewById(R.id.jawab3_3_soalman);
        final RadioButton sdf4 = (RadioButton)findViewById(R.id.jawab4_3_soalman);
        final RadioButton sdf5 = (RadioButton)findViewById(R.id.jawab5_2_soalman);

        final RadioButton sdf6 = (RadioButton)findViewById(R.id.jawab6_3_soalman);
        final RadioButton sdf7 = (RadioButton)findViewById(R.id.jawab7_3_soalman);
        final RadioButton sdf8 = (RadioButton)findViewById(R.id.jawab8_1_soalman);
        final RadioButton sdf9 = (RadioButton)findViewById(R.id.jawab9_4_soalman);
        final RadioButton sdf10 = (RadioButton)findViewById(R.id.jawab10_1_soalman);

        home = (TextView) findViewById(R.id.btnHome);
        sel_soalman= (Button) findViewById(R.id.selesai_soalman);
        lat_man = (Button) findViewById(R.id.latihanman);

        sel_soalman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailPengguna_s = emailPengguna.getText().toString();
                if(sdf1.isChecked() == true){

                    flag =flag+1;
                    if(flag >=1){
                        flag=+1;
                    }
//                    marks = correct;
                }

                if(sdf2.isChecked()==true){

                    flag +=1;
                    if(flag >=1){
                        flag=+1;
                    }
//                    marks = correct;
                }
                if(sdf3.isChecked()==true){
                    flag +=1;
//                    if(flag >=1){
//                        flag=+1;}
//                    marks = correct;
                }

                if(sdf4.isChecked()==true){
                    flag +=1;
//                    if(flag >=1){
//                        flag=+1;}

                }
                if(sdf5.isChecked() == true){
                    flag +=1;


                }
                if(sdf6.isChecked() == true){

                    flag =flag+1;
//                    if(flag >=1){
//                        flag=+1;
//                    }
//                    marks = correct;
                }

                if(sdf7.isChecked()==true){

                    flag +=1;
//                     if(flag >=1){
//                         flag=+1;
//                     }
//                    marks = correct;
                }
                if(sdf8.isChecked()==true){
                    flag +=1;
//                    if(flag >=1){
//                        flag=+1;}
//                    marks = correct;
                }

                if(sdf9.isChecked()==true){
                    flag +=1;
//                    if(flag >=1){
//                        flag=+1;}

                }
                if(sdf10.isChecked() == true){
                    flag +=1;


                }

                if(flag ==1){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =0;
                        wrong = 10;
                    }

                }
                if(flag ==1){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =1;
                        wrong = 9;
                    }

                }
                if(flag ==2){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =2;
                        wrong = 8;
                    }

                }
                if(flag == 3){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =3;
                        wrong = 7;
                    }

                }
                if(flag ==4){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =4;
                        wrong = 6;
                    }

                }
                if(flag ==5){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =5;
                        wrong = 5;
                    }
                }
                if(flag ==1){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =6;
                        wrong = 4;
                    }

                }
                if(flag ==2){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =7;
                        wrong = 3;
                    }

                }
                if(flag == 3){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =8;
                        wrong = 2;
                    }

                }
                if(flag ==4){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =9;
                        wrong = 1;
                    }

                }
                if(flag ==10){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =10;
                        wrong = 0;
                    }
                }
                marks = correct * ifcorect;
                final String benar, salah, nilai;
                benar = String.valueOf(correct);
                salah = String.valueOf(wrong);
                nilai = String.valueOf(marks);
                Toast.makeText(manajemen_soal.this, "Benar : " + correct + "\nSalah : " + wrong +"\nNilai : " + marks, Toast.LENGTH_SHORT).show();
                String keys = ref.push().getKey();
                Laporan laporan = new Laporan(emailPengguna_s,benar, salah, nilai);
                ref.child(keys).setValue(laporan);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manajemen_soal.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lat_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manajemen_soal.this, manajemen_latihan.class);
                startActivity(intent);
            }
        });

    }
}
