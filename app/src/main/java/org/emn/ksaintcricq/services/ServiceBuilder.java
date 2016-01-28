package org.emn.ksaintcricq.services;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ServiceBuilder {

    private static ServiceBuilder INSTANCE = new ServiceBuilder();

    public static ServiceBuilder getInstance() {
        return INSTANCE;
    }

    public <T> T build(String url, Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

}
