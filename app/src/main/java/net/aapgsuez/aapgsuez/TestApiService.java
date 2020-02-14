package net.aapgsuez.aapgsuez;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestApiService {
    @GET("iq-practice.json")
    Call<ArrayList<TestResponse>> getQuestions();

}
