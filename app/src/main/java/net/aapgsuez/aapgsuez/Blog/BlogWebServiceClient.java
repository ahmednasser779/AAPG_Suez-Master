package net.aapgsuez.aapgsuez.Blog;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlogWebServiceClient {

    private static Retrofit retrofit = null;
    public static final String Base_URL = "http://aapgsuez.net/android/android-app/";

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
