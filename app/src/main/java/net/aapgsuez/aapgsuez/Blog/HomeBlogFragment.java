package net.aapgsuez.aapgsuez.Blog;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import net.aapgsuez.aapgsuez.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeBlogFragment extends Fragment {

    View view;
    SliderView sliderView;
    RecyclerView recentRecyclerView;
    ArrayList<BlogArticle> mList;
    ArrayList<BlogArticle> linkList;
    RecentAdapter blogAdapter;
    Context context;
    private ProgressBar progressBar;
    private TextView mEmptyText;
    private SwipeRefreshLayout pullToRefresh;

    public HomeBlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.imageSlider);
        recentRecyclerView = view.findViewById(R.id.recent_recycler_view);
        progressBar = view.findViewById(R.id.loading_indicator_blog);
        mEmptyText = view.findViewById(R.id.empty_view_blog);
        pullToRefresh = view.findViewById(R.id.pullToRefresh_blog);

        pullToRefresh.setColorSchemeResources(R.color.colorPrimaryBlog);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getActivity().recreate();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(pullToRefresh.isRefreshing()){
                            pullToRefresh.setRefreshing(false);
                        }
                    }
                },1000);
            }
        });

        progressBar.setVisibility(View.VISIBLE);

        SliderAdapterExample adapter = new SliderAdapterExample(getActivity());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        callApi();

        mList = new ArrayList<>();
        blogAdapter = new RecentAdapter(mList , context , null);
        recentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false));
        recentRecyclerView.setAdapter(blogAdapter);

        return view;
    }

    private void callApi() {

        BlogApiService blogApiService = BlogWebServiceClient.getRetrofit().create(BlogApiService.class);
        Call<BlogResponse> call = blogApiService.getBlogArticles();
        call.enqueue(new Callback<BlogResponse>() {
            @Override
            public void onResponse(Call<BlogResponse> call, Response<BlogResponse> response) {
                Log.e("Success" , response.body().getBlogArticles().get(0).getName());
                if(response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    for(int i = 0; i < 10; i++){
                        String name = response.body().getBlogArticles().get(i).getName();
                        String date = response.body().getBlogArticles().get(i).getDate();
                        String desc = response.body().getBlogArticles().get(i).getDescription();
                        String image = response.body().getBlogArticles().get(i).getImage();
                        mList.add(new BlogArticle(name , desc , date , image));
                        linkList = new ArrayList<>();
                        linkList = (ArrayList<BlogArticle>) response.body().getBlogArticles();
                        blogAdapter = new RecentAdapter(mList, context, new RecentAdapter.OnArticleClickListener() {
                            @Override
                            public void onArticleClick(int position) {
                                BlogArticle blogArticle = linkList.get(position);
                                String URL = blogArticle.getLink();
                                Intent intent = new Intent(getActivity() , BlogWebView.class);
                                intent.putExtra("url", URL);
                                startActivity(intent);
                            }
                        });
                        recentRecyclerView.setAdapter(blogAdapter);
                    }

                }
                else {
                    Toast.makeText(getActivity(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable t) {
                Log.e("Fail" , t.getMessage());
                progressBar.setVisibility(View.GONE);
                mEmptyText.setText("Check Your Internet Connection");
            }
        });
    }

}
