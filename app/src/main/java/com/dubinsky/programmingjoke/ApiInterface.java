package com.dubinsky.programmingjoke;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("Programming")
    Observable<Joke> joke(@Query("idRange") int id);

    @GET("Programming?type=twopart&amount=10")
    Observable<JokesList> jokes();
}
