package com.example.projectruangdosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class akuntansi_latihan extends AppCompatActivity {

    Button sel_latakun, soal_akun;
    RadioGroup no1_latihan_man, no2_latihan_man, no3_latihan_man;
    TextView home;

    int correct=0, marks=0, wrong=0, blank=0;
    int flag = 0;
    int ifcorect = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akuntansi_latihan);

        final RadioButton sdf1 = (RadioButton)findViewById(R.id.jawab1_4_latakun);
        final RadioButton sdf2 = (RadioButton)findViewById(R.id.jawab2_4_latakun);
        final RadioButton sdf3 = (RadioButton)findViewById(R.id.jawab3_4_latakun);
        final RadioButton sdf4 = (RadioButton)findViewById(R.id.jawab4_2_latakun);
        final RadioButton sdf5 = (RadioButton)findViewById(R.id.jawab5_1_latakun);


        home = (TextView) findViewById(R.id.btnHome);
        sel_latakun = (Button) findViewById(R.id.selesai_latakun);
        soal_akun = (Button) findViewById(R.id.soalakun);

        sel_latakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sdf1.isChecked() == true){

                    flag =flag+1;
//                    if(flag >=1){
//                        flag=+1;
//                    }
//                    marks = correct;
                }

                if(sdf2.isChecked()==true){

                    flag +=1;
//                     if(flag >=1){
//                         flag=+1;
//                     }
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

                if(flag ==1){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =1;
                        wrong = 4;
                    }

                }
                if(flag ==2){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =2;
                        wrong = 3;
                    }

                }
                if(flag == 3){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =3;
                        wrong = 2;
                    }

                }
                if(flag ==4){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =4;
                        wrong = 1;
                    }

                }
                if(flag ==5){
                    flag =+1;
                    flag--;
                    if(flag ==flag){
                        correct =5;
                        wrong = 0;
                    }
                }
                marks = correct * ifcorect;
                Toast.makeText(akuntansi_latihan.this, "Benar : " + correct + "\nSalah : " + wrong +"\nNilai : " + marks, Toast.LENGTH_SHORT).show();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(akuntansi_latihan.this, MainActivity.class);
                startActivity(intent);
            }
        });

        soal_akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(akuntansi_latihan.this, akuntansi_soal.class);
                startActivity(intent);
            }
        });

    }
}
