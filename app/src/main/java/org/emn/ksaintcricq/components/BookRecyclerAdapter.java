package org.emn.ksaintcricq.components;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.emn.ksaintcricq.R;
import org.emn.ksaintcricq.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.ViewHolder> {

    private List<Book> books;
    private final Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(BookItemView itemView) {
            super(itemView);
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
        ((BookItemView) holder.itemView).bindView(this.books.get(position));
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

}
