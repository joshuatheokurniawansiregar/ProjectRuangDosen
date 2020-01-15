package com.example.projectruangdosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Report extends AppCompatActivity {

    TextView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        home = findViewById(R.id.btnHome);

        final RecyclerView recyclerView= (RecyclerView)findViewById(R.id.recyclerView);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Report.this, MainActivity.class);
                startActivity(intent);
            }
        });

        new FireBaseDataHelper().readReport(new FireBaseDataHelper.DataStatus() {
            @Override
            public void dataIsLoad(List<Laporan> books, List<String> keys) {
                new RecyclerView__Config().setConfig(recyclerView, Report.this, books, keys);

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
