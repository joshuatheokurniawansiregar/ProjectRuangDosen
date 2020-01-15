package com.example.projectruangdosen;

import com.example.projectruangdosen.Laporan;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class FireBaseDataHelper {

    private DatabaseReference mReferenceBooks;
    private FirebaseDatabase mDatabase;
    private List<Laporan> books = new ArrayList<>();


    public interface DataStatus{
        void dataIsLoad(List<Laporan> books,List<String> keys);
        void dataIsUpdate();
        void dataIsDeleted();
    }

    public FireBaseDataHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceBooks = mDatabase.getReference("Report");
    }

    public void readReport(final DataStatus dataStatus)
    {
        mReferenceBooks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                books.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode:dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    Laporan laporan = keyNode.getValue(Laporan.class);
                    books.add(laporan);

                }
                dataStatus.dataIsLoad(books,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
