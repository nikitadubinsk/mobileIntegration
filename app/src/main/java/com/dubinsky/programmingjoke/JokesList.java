package com.dubinsky.programmingjoke;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokesList {

    @SerializedName("jokes")
    List<Joke> joke;

}
