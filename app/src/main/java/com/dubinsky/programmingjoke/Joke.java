package com.dubinsky.programmingjoke;

import com.google.gson.annotations.SerializedName;

public class Joke {

    @SerializedName("id")
    int id;

    @SerializedName("setup")
    String setup;

    @SerializedName("delivery")
    String delivery;

}
