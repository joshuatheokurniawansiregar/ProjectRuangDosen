package com.example.projectruangdosen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView_Config_Account {
    private Context mContext;
    private BooksAdapter mBooksAdapter;

    public void setConfig(RecyclerView recyclerView,Context context,List<User> books, List<String> keys)
    {
        mContext = context;
        mBooksAdapter = new BooksAdapter(books,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mBooksAdapter);
    }

    class BookItemView extends RecyclerView.ViewHolder
    {
        private TextView mnama;
        private TextView memail;
        private TextView mpass;
        private TextView mtgl;
        private TextView mnotelp;

        private String key;

        public BookItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.list_view_account,parent,false));

            mnama = (TextView) itemView.findViewById(R.id.email_TextView_account);
            memail = (TextView) itemView.findViewById(R.id.name_textView_account);
            mpass = (TextView) itemView.findViewById(R.id.password_textView);
            mtgl = (TextView) itemView.findViewById(R.id.tanggallahir_TextView);
            mnotelp = (TextView) itemView.findViewById(R.id.notelp_TextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,AccountData.class);
                    intent.putExtra("key",key);
                    intent.putExtra("nama",mnama.getText().toString());
                    intent.putExtra("email",memail.getText().toString());
                    intent.putExtra("password",mpass.getText().toString());
                    intent.putExtra("tanggallahir",mtgl.getText().toString());
                    intent.putExtra("notelp",mnotelp.getText().toString());

                    mContext.startActivity(intent);
                }
            });
        }

        public void bind(User books, String key)
        {
            mnama.setText(books.getName());
            memail.setText(books.getEmail());
            mpass.setText(books.getPassword());
            mtgl.setText(books.getTanggallahir());
            mnotelp.setText(books.getNotelp());
            this.key = key;
        }
    }

    class BooksAdapter extends RecyclerView.Adapter<BookItemView>
    {
        private List<User> mBookLIst;
        private List<String> mKeys;

        @NonNull
        @Override
        public BookItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BookItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BookItemView holder, int position) {
            holder.bind(mBookLIst.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mBookLIst.size();
        }

        public BooksAdapter(List<User> mBookLIst, List<String> mKeys) {
            this.mBookLIst = mBookLIst;
            this.mKeys = mKeys;
        }
    }

}