package com.example.thais.testeretrofit3.services;

import com.example.thais.testeretrofit3.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by thais on 02/05/18.
 */

public interface UserAPI {

    @GET("/users/{usuario}")
    Call<Usuario> getUsuario(@Path("usuario") String usuario);

    @GET("/users/{usuario}/followers")
    Call<List<Usuario>>  getSeguidores(@Path("usuario")  String  usuario);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

