package org.emn.ksaintcricq.components;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.emn.ksaintcricq.R;
import org.emn.ksaintcricq.model.Book;
import org.emn.ksaintcricq.services.BookService;
import org.emn.ksaintcricq.services.ServiceBuilder;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class BookListFragment extends Fragment {

    private BookRecyclerAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_list_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.books);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookRecyclerAdapter(this.getContext());
        recyclerView.setAdapter(adapter);

        BookService service = ServiceBuilder.getInstance().build("http://henri-potier.xebia.fr/", BookService.class);
        Call<List<Book>> call = service.listBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {
                // TODO append books twice just for testing
                List<Book> books = response.body();
                books.addAll(response.body());
                adapter.setBooks(books);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(BookListFragment.this.getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
