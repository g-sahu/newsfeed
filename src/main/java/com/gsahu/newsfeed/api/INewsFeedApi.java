package com.gsahu.newsfeed.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.gsahu.newsfeed.model.NewsFeedResponse;

public interface INewsFeedApi {
    @GET("articles")
    Call<NewsFeedResponse> getArticles(@Query("source") String source, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);
}
