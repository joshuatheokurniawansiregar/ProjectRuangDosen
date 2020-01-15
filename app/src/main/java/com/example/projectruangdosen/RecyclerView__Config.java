package com.example.projectruangdosen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView__Config {

    private Context mContext;
    private BooksAdapter mLaporanAdapter;

    public void setConfig(RecyclerView recyclerView,Context context,List<Laporan> laporans, List<String> keys)
    {
        mContext = context;
        mLaporanAdapter = new BooksAdapter(laporans,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mLaporanAdapter);
    }

    class BookItemView extends RecyclerView.ViewHolder
    {
        private TextView mTitle;
        private TextView mAuthor;
        private TextView mISBN;
        private TextView mCategory;

        private String key;

        public BookItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.list_view_report,parent,false));

            mTitle = (TextView) itemView.findViewById(R.id.email_TextView);
            mAuthor = (TextView) itemView.findViewById(R.id.benar_textView);
            mISBN = (TextView) itemView.findViewById(R.id.salah_TextView);
            mCategory = (TextView) itemView.findViewById(R.id.totalNilai_TextView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Intent intent = new Intent(mContext,BooksDetailsActivity.class);
//                    intent.putExtra("key",key);
//                    intent.putExtra("author",mAuthor.getText().toString());
//                    intent.putExtra("title",mTitle.getText().toString());
//                    intent.putExtra("category",mCategory.getText().toString());
//                    intent.putExtra("isbn",mISBN.getText().toString());
//
//                    mContext.startActivity(intent);
//                }
//            });
        }

        public void bind(Laporan laporan, String key)
        {
            mTitle.setText(laporan.getEmail());
            mAuthor.setText(laporan.getBenar());
            mISBN.setText(laporan.getSalah());
            mCategory.setText(laporan.getTotalNila());
            this.key = key;
        }
    }

    class BooksAdapter extends RecyclerView.Adapter<BookItemView>
    {
        private List<Laporan> mBookLIst;
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

        public BooksAdapter(List<Laporan> mBookLIst, List<String> mKeys) {
            this.mBookLIst = mBookLIst;
            this.mKeys = mKeys;
        }
    }


}