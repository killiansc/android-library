package org.emn.ksaintcricq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.emn.ksaintcricq.components.BookListFragment;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity);

        boolean landscape = getResources().getBoolean(R.bool.landscape);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.book_list, new BookListFragment(), BookListFragment.class.getSimpleName())
                .commit();
    }

}
