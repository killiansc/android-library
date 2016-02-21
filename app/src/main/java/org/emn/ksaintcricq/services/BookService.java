package org.emn.ksaintcricq.services;

import org.emn.ksaintcricq.model.Book;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface BookService {

    @GET("books")
    Call<List<Book>> listBooks();

}
