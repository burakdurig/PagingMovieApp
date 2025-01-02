package com.mastercoding.pagingapp.api;

import static com.mastercoding.pagingapp.util.Utils.API_KEY;
import static com.mastercoding.pagingapp.util.Utils.BASE_Url;

import com.mastercoding.pagingapp.model.MovieResponse;

import io.reactivex.rxjava3.core.Single;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class APIClient {

    static APIInterface apiInterface;

    // Create Retrofit Instance
    public static APIInterface getAPIInterface(){
        if (apiInterface == null){
            // we could use retrofit but we will use OKHTTP
            OkHttpClient.Builder client = new OkHttpClient.Builder();

            client.addInterceptor(chain -> {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .build();

                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);
                Request request = requestBuilder.build();
                return chain.proceed(request);
                // the above would be more simple if I just used Retrofit methods
            });

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_Url)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();

            apiInterface = retrofit.create(APIInterface.class);
        }
        return apiInterface;
    }



    // will define the API interface inside this class
    // will call the api per page
    public interface APIInterface{
        @GET("movie/popular")
        Single<MovieResponse> getMoviesByPage(@Query("page") int page);
    }


}
