package com.example.likhit.g_steam.network;

import java.util.List;

import com.example.likhit.g_steam.model.Message;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("inbox.json")
    Call<List<Message>> getInbox();

}
