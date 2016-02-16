package org.emn.ksaintcricq;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.emn.ksaintcricq.components.BookDetailsFragment;
import org.emn.ksaintcricq.components.BookListFragment;
import org.emn.ksaintcricq.components.BookListener;
import org.emn.ksaintcricq.model.Book;

public class LibraryActivity extends AppCompatActivity implements BookListener {

    private View bookListView;
    private View bookDetailsView;
    private boolean landscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity);

        this.landscape = getResources().getBoolean(R.bool.landscape);

        this.bookListView = findViewById(R.id.book_list);
        this.bookDetailsView = findViewById(R.id.book_details_wrapper);

        if (!landscape) bookDetailsView.setVisibility(View.GONE);

        if (savedInstanceState == null) {
            Fragment bookListFragment = new BookListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.book_list, bookListFragment, BookListFragment.class.getSimpleName())
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!landscape) {
            bookDetailsView.setVisibility(View.GONE);
            bookListView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            bookDetailsView.setVisibility(View.GONE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bookDetailsView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBookClick(Book book) {

        BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
        bookDetailsFragment.getArguments().putParcelable(Book.KEY, book);

        if (!landscape) bookListView.setVisibility(View.GONE);
        bookDetailsView.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.book_details, bookDetailsFragment, BookDetailsFragment.class.getSimpleName())
                .addToBackStack(BookListFragment.class.getSimpleName())
                .commit();

    }
}
