package net.aapgsuez.aapgsuez.Blog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import net.aapgsuez.aapgsuez.BottomNavigationViewHelper;
import net.aapgsuez.aapgsuez.IQTestStartActivity;
import net.aapgsuez.aapgsuez.MainActivity;
import net.aapgsuez.aapgsuez.Mozakra;
import net.aapgsuez.aapgsuez.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogActivity extends AppCompatActivity implements View.OnClickListener {

    SliderView sliderView;
    RecyclerView recentRecyclerView;
    ArrayList<BlogArticle> mList;
    ArrayList<BlogArticle> linkList;
    RecentAdapter blogAdapter;
    Context context;
    DrawerLayout drawerLayout;
    ImageView menuIcon , iconBack;
    TextView homeText , marketingText , softSkillsText , designText , technologyText , businessText;
    Button subscribeButton;
    private ProgressBar progressBar;
    private TextView mEmptyText;
    private SwipeRefreshLayout pullToRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        sliderView = findViewById(R.id.imageSlider);
        recentRecyclerView = findViewById(R.id.recent_recycler_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        menuIcon = findViewById(R.id.menu_icon);
        iconBack = findViewById(R.id.icon_arrow_back);
        //homeText = findViewById(R.id.home_text);
        marketingText = findViewById(R.id.marketing_text);
        softSkillsText = findViewById(R.id.softSkills_text);
        designText = findViewById(R.id.design_text);
        technologyText = findViewById(R.id.technology_text);
        businessText = findViewById(R.id.business_text);
        //subscribeButton = findViewById(R.id.subscribe_button);
        progressBar = findViewById(R.id.loading_indicator_blog);
        mEmptyText = findViewById(R.id.empty_view_blog);
        pullToRefresh = findViewById(R.id.pullToRefresh_blog);

        pullToRefresh.setColorSchemeResources(R.color.colorPrimaryBlog);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recreate();
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

        drawerLayout.setOnClickListener(this);
        menuIcon.setOnClickListener(this);
        iconBack.setOnClickListener(this);
       // homeText.setOnClickListener(this);
        marketingText.setOnClickListener(this);
        softSkillsText.setOnClickListener(this);
        designText.setOnClickListener(this);
        technologyText.setOnClickListener(this);
        businessText.setOnClickListener(this);
       // subscribeButton.setOnClickListener(this);

        SliderAdapterExample adapter = new SliderAdapterExample(this);
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
        recentRecyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        recentRecyclerView.setAdapter(blogAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.icon_blog:

                        break;

                    case R.id.icon_home:
                        Intent intent1 = new Intent(BlogActivity.this, MainActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;

                    case R.id.icon_materials:
                        Intent intent2 = new Intent(BlogActivity.this, Mozakra.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;

                    case R.id.icon_iq_test:
                        Intent intent3 = new Intent(BlogActivity.this, IQTestStartActivity.class);
                        intent3.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;


                }


                return false;
            }
        });
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
                                Intent intent = new Intent(BlogActivity.this , BlogWebView.class);
                                intent.putExtra("url", URL);
                                startActivity(intent);
                            }
                        });
                        recentRecyclerView.setAdapter(blogAdapter);
                    }

                }
                else {
                    Toast.makeText(BlogActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
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

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.replace_layout , fragment).addToBackStack("TAG").commit();
        drawerLayout.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                recreate();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.menu_icon:
                drawerLayout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.icon_arrow_back:
                onBackPressed();
                break;
           /* case R.id.home_text:
                loadFragment(new HomeBlogFragment());
                break;*/
            case R.id.marketing_text:
                loadFragment(new MarketingFragment());
                break;
            case R.id.softSkills_text:
                loadFragment(new SoftSkillsFragment());
                break;
            case R.id.design_text:
                loadFragment(new DesignFragment());
                break;
            case R.id.technology_text:
                loadFragment(new TechnologyFragment());
                break;
            case R.id.business_text:
                loadFragment(new BusinessFragment());
                break;
           /* case R.id.subscribe_button:
                Intent subscribeIntent = new Intent(BlogActivity.this , SubscribeActivity.class);
                startActivity(subscribeIntent);
                drawerLayout.closeDrawers();
                break;*/
        }
    }
}
