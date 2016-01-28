package org.emn.ksaintcricq.services;

import org.emn.ksaintcricq.model.Book;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface HenriPotierService {

    // TODO Method GET books which return a List<Book>

    @GET("books")
    Call<List<Book>> listBooks();

}
