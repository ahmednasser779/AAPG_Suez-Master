package net.aapgsuez.aapgsuez.Blog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BlogApiService {

    @GET("blog-recent.php")
    Call<BlogResponse> getBlogArticles();


}
