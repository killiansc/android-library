package org.emn.ksaintcricq.components;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.emn.ksaintcricq.R;
import org.emn.ksaintcricq.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.ViewHolder> {

    private final Context context;
    private List<Book> books;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private BookListener listener;
        private Book book;

        public ViewHolder(BookItemView itemView) {
            super(itemView);
            this.listener = (BookListener) itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void setBook(Book book) {
            this.book = book;
        }

        @Override
        public void onClick(View v) {
            this.listener.onBookClick(book);
        }

    }

    public BookRecyclerAdapter(Context context) {
        this.books = new ArrayList<>();
        this.context = context;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BookItemView v = (BookItemView) LayoutInflater
                .from(context)
                .inflate(R.layout.custom_view_item_book, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book current = this.books.get(position);
        holder.setBook(current);
        ((BookItemView) holder.itemView).bindView(current);
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

}
