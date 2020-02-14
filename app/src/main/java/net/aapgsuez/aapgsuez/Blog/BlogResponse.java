
package net.aapgsuez.aapgsuez.Blog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogResponse {

    @SerializedName("Blog Articles")
    @Expose
    private List<BlogArticle> blogArticles = null;

    public List<BlogArticle> getBlogArticles() {
        return blogArticles;
    }

    public void setBlogArticles(List<BlogArticle> blogArticles) {
        this.blogArticles = blogArticles;
    }

}
