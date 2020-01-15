package com.example.projectruangdosen;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class FirebaseDataHelper_User {

    private DatabaseReference mReferenceUser;
    private FirebaseDatabase mDatabase_user;
    private List<User> users = new ArrayList<>();


    public interface DataStatus {
        void dataIsLoad(List<User> users, List<String> keys);

        void dataIsUpdate();

        void dataIsDeleted();
    }

    public FirebaseDataHelper_User() {
        mDatabase_user = FirebaseDatabase.getInstance();
        mReferenceUser = mDatabase_user.getReference("User");
    }

    public void readAccount(final DataStatus dataStatus) {
        mReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                users.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    User user1 = keyNode.getValue(User.class);
                    users.add(user1);

                }
                dataStatus.dataIsLoad(users, keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateBook(String key, User users, final DataStatus dataStatus) {
        mReferenceUser.child(key).setValue(users)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.dataIsUpdate();
                    }
                });
    }

    public void deleteBook(String key, final DataStatus dataStatus) {
        mReferenceUser.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.dataIsDeleted();
            }
        });

    }
}
