package org.emn.ksaintcricq.components;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.emn.ksaintcricq.R;
import org.emn.ksaintcricq.model.Book;
import org.w3c.dom.Text;

public class BookDetailsFragment extends Fragment {

    public BookDetailsFragment() {
        super();
        setArguments(new Bundle());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_details_fragment, container, false);

        Book book = (Book) getArguments().getParcelable(Book.KEY);
        TextView isbn = (TextView) view.findViewById(R.id.detail_isbn);
        isbn.setText(book.getIsbn());
        TextView title = (TextView) view.findViewById(R.id.detail_title);
        title.setText(book.getTitle());
        TextView price = (TextView) view.findViewById(R.id.detail_price);
        price.setText(getResources().getString(R.string.euros, book.getPrice()));
        ImageView cover = (ImageView) view.findViewById(R.id.detail_cover);
        Glide.with(view.getContext())
                .load(book.getCover())
                .into(cover);

        return view;
    }


}
