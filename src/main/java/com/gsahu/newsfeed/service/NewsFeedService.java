package com.gsahu.newsfeed.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.gsahu.newsfeed.api.INewsFeedApi;
import com.gsahu.newsfeed.dao.NewsFeedDao;
import com.gsahu.newsfeed.model.Article;
import com.gsahu.newsfeed.model.NewsFeedResponse;
import com.gsahu.newsfeed.util.Constants;

@Service
public class NewsFeedService {
	public static final String LOG_TAG_EXCEPTION = "Exception";
	public static final String BASE_URL = "https://newsapi.org/v1/";
    private static Retrofit retrofit = null;
    
    @Autowired
    private NewsFeedDao newsFeedDao;
	
	public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
	
	public List<Article> fetchArticles() {
		INewsFeedApi apiService = getClient().create(INewsFeedApi.class);
        Call<NewsFeedResponse> call = apiService.getArticles(Constants.SOURCE_BBC, Constants.SORT_ORDER_TOP, Constants.API_KEY);
        
        try {
        	Response<NewsFeedResponse> response = call.execute();
        	List<Article> articles = response.body().getArticles();
        	newsFeedDao.saveArticles(articles);
        	return articles;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
