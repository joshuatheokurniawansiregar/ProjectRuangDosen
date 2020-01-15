package com.example.projectruangdosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class manajemen_latihan extends AppCompatActivity {

    Button sel_lataman, soal_man;
    TextView home;
    RadioGroup no1_latihan_man, no2_latihan_man, no3_latihan_man;

    int correct=0, marks=0, wrong=0, blank=0;
    int flag = 0;
    int ifcorect = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manajemen_latihan);

        no1_latihan_man = (RadioGroup)findViewById(R.id.no1_rg);
        no2_latihan_man = (RadioGroup)findViewById(R.id.no2_rg);
        no3_latihan_man = (RadioGroup)findViewById(R.id.no3_rg);


        final RadioButton sdf1 = (RadioButton)findViewById(R.id.jawab1_1_latman);
        final RadioButton sdf2 = (RadioButton)findViewById(R.id.jawab2_3_latman);
        final RadioButton sdf3 = (RadioButton)findViewById(R.id.jawab3_3_latman);
        final RadioButton sdf4 = (RadioButton)findViewById(R.id.jawab4_5_latman);
        final RadioButton sdf5 = (RadioButton)findViewById(R.id.jawab5_2_latman);


        home = (TextView) findViewById(R.id.btnHome);
        sel_lataman= (Button) findViewById(R.id.selesai_latman);
        soal_man = (Button) findViewById(R.id.soalman);

        sel_lataman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!no1_latihan_manA.isSelected()||!no1_latihan_manB.isSelected() || !no1_latihan_manC.isSelected() || !no1_latihan_manD.isSelected() || !no1_latihan_manE.isSelected()){
//                    blank += 1;
//                String no1_latihan_manA =  ((RadioButton)findViewById(no1_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no1_latihan_manB = ((RadioButton)findViewById(no1_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no1_latihan_manC = ((RadioButton)findViewById(no1_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no1_latihan_manD = ((RadioButton)findViewById(no1_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no1_latihan_manE = ((RadioButton)findViewById(no1_latihan_man.getCheckedRadioButtonId())).getText().toString();
//
//                no2_latihan_manA = ((RadioButton)findViewById(no2_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no2_latihan_manB = ((RadioButton)findViewById(no2_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no2_latihan_manC = ((RadioButton)findViewById(no2_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no2_latihan_manD = ((RadioButton)findViewById(no2_latihan_man.getCheckedRadioButtonId())).getText().toString();
//                no2_latihan_manE = ((RadioButton)findViewById(no2_latihan_man.getCheckedRadioButtonId())).getText().toString();
                 if(sdf1.isChecked() == true){
                     flag++;
//                     if(flag >1){
//
//                         flag--;
////                         flag = flag+1;
//                     }
//

//                    marks = correct;
                }

                 if(sdf2.isChecked()==true){
                     flag++;
//                     if(flag >1){
//                         flag =+ flag;
//                         flag--;
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



//                if(sdf2.isChecked()==true){
//                    correct=+1;
//                }else{
//                    wrong ++;
//                }

//                }else{
//                    correct +=0;
//                }

//                if(!no2_latihan_manA.isSelected()||!no2_latihan_manB.isSelected() || !no2_latihan_manC.isSelected() || !no2_latihan_manD.isSelected() || !no2_latihan_manE.isSelected()){
//                    blank += 1;
//                }if (no2_latihan_manC.isSelected()){
//                    correct =correct+ ifcorect;
//                    Toast.makeText(manajemen_latihan.this, "Benar", Toast.LENGTH_SHORT).show();
//                }
//                if(no1_latihan_manA.isSelected()){
//                    correct += ifcorect;
//                    marks = correct;
//                }else{
//                    correct +=0;
//                }

                marks = correct * ifcorect;


                Toast.makeText(manajemen_latihan.this, "Benar : " + correct + "\nSalah : " + wrong +"\nNilai : " + marks, Toast.LENGTH_SHORT).show();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manajemen_latihan.this, MainActivity.class);
                startActivity(intent);

            }
        });

        soal_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manajemen_latihan.this, manajemen_soal.class);
                startActivity(intent);
            }
        });

    }
}
