package net.aapgsuez.aapgsuez;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("json.php")
    Call<MagazineResponse> getMagazines();
}
