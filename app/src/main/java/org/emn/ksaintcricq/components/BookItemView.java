package org.emn.ksaintcricq.components;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.emn.ksaintcricq.R;
import org.emn.ksaintcricq.model.Book;

public class BookItemView extends LinearLayout {

    private TextView nameTextView;
    private TextView priceTextView;
    private ImageView coverImageView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        nameTextView = (TextView) findViewById(R.id.name);
        priceTextView = (TextView) findViewById(R.id.price);
        coverImageView = (ImageView) findViewById(R.id.cover);
    }

    public void bindView(Book book) {
        nameTextView.setText(book.getTitle());
        priceTextView.setText(getResources().getString(R.string.euros, book.getPrice()));
        Glide.with(this.getContext())
                .load(book.getCover())
                .centerCrop()
                .into(coverImageView);
    }

}
