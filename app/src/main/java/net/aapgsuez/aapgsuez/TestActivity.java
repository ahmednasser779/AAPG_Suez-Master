package net.aapgsuez.aapgsuez;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    TextView q1 , q2 , q3 , q4 , q5 , q6 , q7 , q8 , q9 , q10;
    String question1Text , question1A , question1B , question1C , question1D , question1E , question1True ;
    String question2Text , question2A , question2B , question2C , question2D , question2E , question2True ;
    String question3Text , question3A , question3B , question3C , question3D , question3E , question3True ;
    String question4Text , question4A , question4B , question4C , question4D , question4E , question4True ;
    String question5Text , question5A , question5B , question5C , question5D , question5E , question5True ;
    String question6Text , question6A , question6B , question6C , question6D , question6E , question6True ;
    String question7Text , question7A , question7B , question7C , question7D , question7E , question7True ;
    String question8Text , question8A , question8B , question8C , question8D , question8E , question8True ;
    String question9Text , question9A , question9B , question9C , question9D , question9E , question9True ;
    String question10Text , question10A , question10B , question10C , question10D , question10E , question10True ;
    RadioButton q1A, q1B , q1C , q1D , q1E, q2A, q2B , q2C , q2D , q2E;
    RadioButton q3A, q3B , q3C , q3D , q3E, q4A, q4B , q4C , q4D , q4E;
    RadioButton q5A, q5B , q5C , q5D , q5E, q6A, q6B , q6C , q6D , q6E;
    RadioButton q7A, q7B , q7C , q7D , q7E, q8A, q8B , q8C , q8D , q8E;
    RadioButton q9A, q9B , q9C , q9D , q9E, q10A, q10B , q10C , q10D , q10E;
    ImageView q1Image ,q2Image , q3Image ,q4Image, q5Image, q6Image, q7Image, q8Image, q9Image, q10Image;
    ProgressBar progressBar;
    CardView Q1_group , Q2_group , Q3_group , Q4_group , Q5_group , Q6_group , Q7_group , Q8_group , Q9_group , Q10_group ;
    private TextView mEmptyText;
    Button submit;
    Intent resultIntent;
    private SwipeRefreshLayout pullToRefresh;
    private int i1 , i2 , i3 , i4 , i5 , i6 , i7 , i8 , i9 , i10;
    int score = 0;

    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimeRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("IQ Test");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.loading_indicator);
        progressBar.setVisibility(View.VISIBLE);
        mEmptyText = findViewById(R.id.empty_view);
        submit = findViewById(R.id.submit);
        pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorSchemeResources(R.color.colorPrimary);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(mTimeRunning){
                    mCountDownTimer.cancel();
                }
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
        resultIntent = new Intent(TestActivity.this , ResultActivity.class);

        mTextViewCountDown = findViewById(R.id.timer);

        Random random = new Random();

        i1 = random.nextInt(10 - 0);
        i2 = random.nextInt(20 - 10) + 10;
        i3 = random.nextInt(30 - 20) + 20;
        i4 = random.nextInt(40 - 30) + 30;
        i5 = random.nextInt(50 - 40) + 40;
        i6 = random.nextInt(60 - 50) + 50;
        i7 = random.nextInt(70 - 60) + 60;
        i8 = random.nextInt(80 - 70) + 70;
        i9 = random.nextInt(90 - 80) + 80;
        i10 = random.nextInt(100 - 90) + 90;

        Q1_group = findViewById(R.id.Q1);
        Q2_group = findViewById(R.id.Q2);
        Q3_group = findViewById(R.id.Q3);
        Q4_group = findViewById(R.id.Q4);
        Q5_group = findViewById(R.id.Q5);
        Q6_group = findViewById(R.id.Q6);
        Q7_group = findViewById(R.id.Q7);
        Q8_group = findViewById(R.id.Q8);
        Q9_group = findViewById(R.id.Q9);
        Q10_group = findViewById(R.id.Q10);

        q1 = findViewById(R.id.Q1_text);
        q1Image = findViewById(R.id.question1_image);
        q1A = findViewById(R.id.Q1A);
        q1B = findViewById(R.id.Q1B);
        q1C = findViewById(R.id.Q1C);
        q1D = findViewById(R.id.Q1D);
        q1E = findViewById(R.id.Q1E);

        q2 = findViewById(R.id.Q2_text);
        q2Image = findViewById(R.id.question2_image);
        q2A = findViewById(R.id.Q2A);
        q2B = findViewById(R.id.Q2B);
        q2C = findViewById(R.id.Q2C);
        q2D = findViewById(R.id.Q2D);
        q2E = findViewById(R.id.Q2E);

        q3 = findViewById(R.id.Q3_text);
        q3Image = findViewById(R.id.question3_image);
        q3A = findViewById(R.id.Q3A);
        q3B = findViewById(R.id.Q3B);
        q3C = findViewById(R.id.Q3C);
        q3D = findViewById(R.id.Q3D);
        q3E = findViewById(R.id.Q3E);

        q4 = findViewById(R.id.Q4_text);
        q4Image = findViewById(R.id.question4_image);
        q4A = findViewById(R.id.Q4A);
        q4B = findViewById(R.id.Q4B);
        q4C = findViewById(R.id.Q4C);
        q4D = findViewById(R.id.Q4D);
        q4E = findViewById(R.id.Q4E);

        q5 = findViewById(R.id.Q5_text);
        q5Image = findViewById(R.id.question5_image);
        q5A = findViewById(R.id.Q5A);
        q5B = findViewById(R.id.Q5B);
        q5C = findViewById(R.id.Q5C);
        q5D = findViewById(R.id.Q5D);
        q5E = findViewById(R.id.Q5E);

        q6 = findViewById(R.id.Q6_text);
        q6Image = findViewById(R.id.question6_image);
        q6A = findViewById(R.id.Q6A);
        q6B = findViewById(R.id.Q6B);
        q6C = findViewById(R.id.Q6C);
        q6D = findViewById(R.id.Q6D);
        q6E = findViewById(R.id.Q6E);

        q7 = findViewById(R.id.Q7_text);
        q7Image = findViewById(R.id.question7_image);
        q7A = findViewById(R.id.Q7A);
        q7B = findViewById(R.id.Q7B);
        q7C = findViewById(R.id.Q7C);
        q7D = findViewById(R.id.Q7D);
        q7E = findViewById(R.id.Q7E);

        q8 = findViewById(R.id.Q8_text);
        q8Image = findViewById(R.id.question8_image);
        q8A = findViewById(R.id.Q8A);
        q8B = findViewById(R.id.Q8B);
        q8C = findViewById(R.id.Q8C);
        q8D = findViewById(R.id.Q8D);
        q8E = findViewById(R.id.Q8E);

        q9 = findViewById(R.id.Q9_text);
        q9Image = findViewById(R.id.question9_image);
        q9A = findViewById(R.id.Q9A);
        q9B = findViewById(R.id.Q9B);
        q9C = findViewById(R.id.Q9C);
        q9D = findViewById(R.id.Q9D);
        q9E = findViewById(R.id.Q9E);

        q10 = findViewById(R.id.Q10_text);
        q10Image = findViewById(R.id.question10_image);
        q10A = findViewById(R.id.Q10A);
        q10B = findViewById(R.id.Q10B);
        q10C = findViewById(R.id.Q10C);
        q10D = findViewById(R.id.Q10D);
        q10E = findViewById(R.id.Q10E);


        callApi();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            onBackPressed();
            if(mTimeRunning){
               mCountDownTimer.cancel();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                if(mTimeRunning){
                    mCountDownTimer.cancel();
                }
                onBackPressed();
                return true;
            default:
                if(mTimeRunning){
                    mCountDownTimer.cancel();
                }
                recreate();

        }
        return super.onOptionsItemSelected(item);
    }


    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault() ,"%02d:%02d" , minutes , seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void callApi() {
        TestApiService apiService = TestWebServicesClient.getRetrofit().create(TestApiService.class);
        Call<ArrayList<TestResponse>> call = apiService.getQuestions();
        call.enqueue(new Callback<ArrayList<TestResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<TestResponse>> call, Response<ArrayList<TestResponse>> response) {
                Log.e("Success" , response.body().get(0).getQuestion()+"");

                if(response.isSuccessful()) {

                    Q1_group.setVisibility(View.VISIBLE);
                    Q2_group.setVisibility(View.VISIBLE);
                    Q3_group.setVisibility(View.VISIBLE);
                    Q4_group.setVisibility(View.VISIBLE);
                    Q5_group.setVisibility(View.VISIBLE);
                    Q6_group.setVisibility(View.VISIBLE);
                    Q7_group.setVisibility(View.VISIBLE);
                    Q8_group.setVisibility(View.VISIBLE);
                    Q9_group.setVisibility(View.VISIBLE);
                    Q10_group.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);

                    question1Text = response.body().get(i1).getQuestion();
                    q1.setText(question1Text);
                    question1A = response.body().get(i1).getAnswers().getAns1();
                    q1A.setText(question1A);
                    question1B = response.body().get(i1).getAnswers().getAns2();
                    q1B.setText(question1B);
                    question1C = response.body().get(i1).getAnswers().getAns3();
                    q1C.setText(question1C);
                    question1D = response.body().get(i1).getAnswers().getAns4();
                    q1D.setText(question1D);
                    if(response.body().get(i1).getAnswers().getAns5().isEmpty()){
                        q1E.setVisibility(View.GONE);
                    } else {
                        q1E.setVisibility(View.VISIBLE);
                        question1E = response.body().get(i1).getAnswers().getAns5();
                        q1E.setText(question1E);
                    }
                    question1True = response.body().get(i1).getTrueAns();
                    if(response.body().get(i1).getImgquestion().isEmpty()){
                        q1Image.setVisibility(View.GONE);
                        q1.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i1).getImgquestion())
                                .into(q1Image);
                        q1Image.setVisibility(View.VISIBLE);
                        q1.setVisibility(View.GONE);
                    }

                    question2Text = response.body().get(i2).getQuestion();
                    q2.setText(question2Text);
                    question2A = response.body().get(i2).getAnswers().getAns1();
                    q2A.setText(question2A);
                    question2B = response.body().get(i2).getAnswers().getAns2();
                    q2B.setText(question2B);
                    question2C = response.body().get(i2).getAnswers().getAns3();
                    q2C.setText(question2C);
                    question2D = response.body().get(i2).getAnswers().getAns4();
                    q2D.setText(question2D);
                    if(response.body().get(i2).getAnswers().getAns5().isEmpty()){
                        q2E.setVisibility(View.GONE);
                    } else {
                        q2E.setVisibility(View.VISIBLE);
                        question2E = response.body().get(i2).getAnswers().getAns5();
                        q2E.setText(question2E);
                    }
                    question2True = response.body().get(i2).getTrueAns();
                    if(response.body().get(i2).getImgquestion().isEmpty()){
                        q2Image.setVisibility(View.GONE);
                        q2.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i2).getImgquestion())
                                .into(q2Image);
                        q2Image.setVisibility(View.VISIBLE);
                        q2.setVisibility(View.GONE);
                    }

                    question3Text = response.body().get(i3).getQuestion();
                    q3.setText(question3Text);
                    question3A = response.body().get(i3).getAnswers().getAns1();
                    q3A.setText(question3A);
                    question3B = response.body().get(i3).getAnswers().getAns2();
                    q3B.setText(question3B);
                    question3C = response.body().get(i3).getAnswers().getAns3();
                    q3C.setText(question3C);
                    question3D = response.body().get(i3).getAnswers().getAns4();
                    q3D.setText(question3D);
                    if(response.body().get(i3).getAnswers().getAns5().isEmpty()){
                        q3E.setVisibility(View.GONE);
                    } else {
                        q3E.setVisibility(View.VISIBLE);
                        question3E = response.body().get(i3).getAnswers().getAns5();
                        q3E.setText(question3E);
                    }
                    question3True = response.body().get(i3).getTrueAns();
                    if(response.body().get(i3).getImgquestion().isEmpty()){
                        q3Image.setVisibility(View.GONE);
                        q3.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i3).getImgquestion())
                                .into(q3Image);
                        q3Image.setVisibility(View.VISIBLE);
                        q3.setVisibility(View.GONE);
                    }

                    question4Text = response.body().get(i4).getQuestion();
                    q4.setText(question4Text);
                    question4A = response.body().get(i4).getAnswers().getAns1();
                    q4A.setText(question4A);
                    question4B = response.body().get(i4).getAnswers().getAns2();
                    q4B.setText(question4B);
                    question4C = response.body().get(i4).getAnswers().getAns3();
                    q4C.setText(question4C);
                    question4D = response.body().get(i4).getAnswers().getAns4();
                    q4D.setText(question4D);
                    if(response.body().get(i4).getAnswers().getAns5().isEmpty()){
                        q4E.setVisibility(View.GONE);
                    } else {
                        q4E.setVisibility(View.VISIBLE);
                        question4E = response.body().get(i4).getAnswers().getAns5();
                        q4E.setText(question4E);
                    }
                    question4True = response.body().get(i4).getTrueAns();
                    if(response.body().get(i4).getImgquestion().isEmpty()){
                        q4Image.setVisibility(View.GONE);
                        q4.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i4).getImgquestion())
                                .into(q4Image);
                        q4Image.setVisibility(View.VISIBLE);
                        q4.setVisibility(View.GONE);
                    }

                    question5Text = response.body().get(i5).getQuestion();
                    q5.setText(question5Text);
                    question5A = response.body().get(i5).getAnswers().getAns1();
                    q5A.setText(question5A);
                    question5B = response.body().get(i5).getAnswers().getAns2();
                    q5B.setText(question5B);
                    question5C = response.body().get(i5).getAnswers().getAns3();
                    q5C.setText(question5C);
                    question5D = response.body().get(i5).getAnswers().getAns4();
                    q5D.setText(question5D);
                    if(response.body().get(i5).getAnswers().getAns5().isEmpty()){
                        q5E.setVisibility(View.GONE);
                    } else {
                        q5E.setVisibility(View.VISIBLE);
                        question5E = response.body().get(i5).getAnswers().getAns5();
                        q5E.setText(question5E);
                    }
                    question5True = response.body().get(i5).getTrueAns();
                    if(response.body().get(i5).getImgquestion().isEmpty()){
                        q5Image.setVisibility(View.GONE);
                        q5.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i5).getImgquestion())
                                .into(q5Image);
                        q5Image.setVisibility(View.VISIBLE);
                        q5.setVisibility(View.GONE);
                    }

                    question6Text = response.body().get(i6).getQuestion();
                    q6.setText(question6Text);
                    question6A = response.body().get(i6).getAnswers().getAns1();
                    q6A.setText(question6A);
                    question6B = response.body().get(i6).getAnswers().getAns2();
                    q6B.setText(question6B);
                    question6C = response.body().get(i6).getAnswers().getAns3();
                    q6C.setText(question6C);
                    question6D = response.body().get(i6).getAnswers().getAns4();
                    q6D.setText(question6D);
                    if(response.body().get(i6).getAnswers().getAns5().isEmpty()){
                        q6E.setVisibility(View.GONE);
                    } else {
                        q6E.setVisibility(View.VISIBLE);
                        question6E = response.body().get(i6).getAnswers().getAns5();
                        q6E.setText(question6E);
                    }
                    question6True = response.body().get(i6).getTrueAns();
                    if(response.body().get(i6).getImgquestion().isEmpty()){
                        q6Image.setVisibility(View.GONE);
                        q6.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i6).getImgquestion())
                                .into(q6Image);
                        q6Image.setVisibility(View.VISIBLE);
                        q6.setVisibility(View.GONE);
                    }

                    question7Text = response.body().get(i7).getQuestion();
                    q7.setText(question7Text);
                    question7A = response.body().get(i7).getAnswers().getAns1();
                    q7A.setText(question7A);
                    question7B = response.body().get(i7).getAnswers().getAns2();
                    q7B.setText(question7B);
                    question7C = response.body().get(i7).getAnswers().getAns3();
                    q7C.setText(question7C);
                    question7D = response.body().get(i7).getAnswers().getAns4();
                    q7D.setText(question7D);
                    if(response.body().get(i7).getAnswers().getAns5().isEmpty()){
                        q7E.setVisibility(View.GONE);
                    } else {
                        q7E.setVisibility(View.VISIBLE);
                        question7E = response.body().get(i7).getAnswers().getAns5();
                        q7E.setText(question7E);
                    }
                    question7True = response.body().get(i7).getTrueAns();
                    if(response.body().get(i7).getImgquestion().isEmpty()){
                        q7Image.setVisibility(View.GONE);
                        q7.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i7).getImgquestion())
                                .into(q7Image);
                        q7Image.setVisibility(View.VISIBLE);
                        q7.setVisibility(View.GONE);
                    }

                    question8Text = response.body().get(i8).getQuestion();
                    q8.setText(question8Text);
                    question8A = response.body().get(i8).getAnswers().getAns1();
                    q8A.setText(question8A);
                    question8B = response.body().get(i8).getAnswers().getAns2();
                    q8B.setText(question8B);
                    question8C = response.body().get(i8).getAnswers().getAns3();
                    q8C.setText(question8C);
                    question8D = response.body().get(i8).getAnswers().getAns4();
                    q8D.setText(question8D);
                    if(response.body().get(i8).getAnswers().getAns5().isEmpty()){
                        q8E.setVisibility(View.GONE);
                    } else {
                        q8E.setVisibility(View.VISIBLE);
                        question8E = response.body().get(i8).getAnswers().getAns5();
                        q8.setText(question8E);
                    }
                    question8True = response.body().get(i8).getTrueAns();
                    if(response.body().get(i8).getImgquestion().isEmpty()){
                        q8Image.setVisibility(View.GONE);
                        q8.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i8).getImgquestion())
                                .into(q8Image);
                        q8Image.setVisibility(View.VISIBLE);
                        q8.setVisibility(View.GONE);
                    }

                    question9Text = response.body().get(i9).getQuestion();
                    q9.setText(question9Text);
                    question9A = response.body().get(i9).getAnswers().getAns1();
                    q9A.setText(question9A);
                    question9B = response.body().get(i9).getAnswers().getAns2();
                    q9B.setText(question9B);
                    question9C = response.body().get(i9).getAnswers().getAns3();
                    q9C.setText(question9C);
                    question9D = response.body().get(i9).getAnswers().getAns4();
                    q9D.setText(question9D);
                    if(response.body().get(i9).getAnswers().getAns5().isEmpty()){
                        q9E.setVisibility(View.GONE);
                    } else {
                        q9E.setVisibility(View.VISIBLE);
                        question9E = response.body().get(i9).getAnswers().getAns5();
                        q9E.setText(question9E);
                    }
                    question9True = response.body().get(i9).getTrueAns();
                    if(response.body().get(i9).getImgquestion().isEmpty()){
                        q9Image.setVisibility(View.GONE);
                        q9.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i9).getImgquestion())
                                .into(q9Image);
                        q9Image.setVisibility(View.VISIBLE);
                        q9.setVisibility(View.GONE);
                    }

                    question10Text = response.body().get(i10).getQuestion();
                    q10.setText(question10Text);
                    question10A = response.body().get(i10).getAnswers().getAns1();
                    q10A.setText(question10A);
                    question10B = response.body().get(i10).getAnswers().getAns2();
                    q10B.setText(question10B);
                    question10C = response.body().get(i10).getAnswers().getAns3();
                    q10C.setText(question10C);
                    question10D = response.body().get(i10).getAnswers().getAns4();
                    q10D.setText(question10D);
                    if(response.body().get(i10).getAnswers().getAns5().isEmpty()){
                        q10E.setVisibility(View.GONE);
                    } else {
                        q10E.setVisibility(View.VISIBLE);
                        question10E = response.body().get(i10).getAnswers().getAns5();
                        q10E.setText(question10E);
                    }
                    question10True = response.body().get(i10).getTrueAns();
                    if(response.body().get(i10).getImgquestion().isEmpty()){
                        q10Image.setVisibility(View.GONE);
                        q10.setVisibility(View.VISIBLE);
                    }else {
                        Glide.with(TestActivity.this)
                                .load(response.body().get(i10).getImgquestion())
                                .into(q10Image);
                        q10Image.setVisibility(View.VISIBLE);
                        q10.setVisibility(View.GONE);
                    }

                    //Start CountDown Timer
                    mCountDownTimer = new CountDownTimer(mTimeLeftInMillis , 1000) {
                        @Override
                        public void onTick(long l) {
                            mTimeLeftInMillis = l;
                            updateCountDownText();
                        }

                        @Override
                        public void onFinish() {
                            if(mTimeRunning){
                                mCountDownTimer.cancel();
                            }
                            if(question1True.equals(question1A) && q1A.isChecked() ){
                                score++;
                            }else if(question1True.equals(question1B) && q1B.isChecked()){
                                score++;
                            }else if(question1True.equals(question1C) && q1C.isChecked()){
                                score++;
                            }else if(question1True.equals(question1D) && q1D.isChecked()){
                                score++;
                            }else if(question1True.equals(question1E) && q1E.isChecked()){
                                score++;
                            }

                            if(question2True.equals(question2A) && q2A.isChecked() ){
                                score++;
                            }else if(question2True.equals(question2B) && q2B.isChecked()){
                                score++;
                            }else if(question2True.equals(question2C) && q2C.isChecked()){
                                score++;
                            }else if(question2True.equals(question2D) && q2D.isChecked()){
                                score++;
                            }else if(question2True.equals(question2E) && q2E.isChecked()){
                                score++;
                            }

                            if(question3True.equals(question3A) && q3A.isChecked() ){
                                score++;
                            }else if(question3True.equals(question3B) && q3B.isChecked()){
                                score++;
                            }else if(question3True.equals(question3C) && q3C.isChecked()){
                                score++;
                            }else if(question3True.equals(question3D) && q3D.isChecked()){
                                score++;
                            }else if(question3True.equals(question3E) && q3E.isChecked()){
                                score++;
                            }

                            if(question4True.equals(question4A) && q4A.isChecked() ){
                                score++;
                            }else if(question4True.equals(question4B) && q4B.isChecked()){
                                score++;
                            }else if(question4True.equals(question4C) && q4C.isChecked()){
                                score++;
                            }else if(question4True.equals(question4D) && q4D.isChecked()){
                                score++;
                            }else if(question4True.equals(question4E) && q4E.isChecked()){
                                score++;
                            }

                            if(question5True.equals(question5A) && q5A.isChecked() ){
                                score++;
                            }else if(question5True.equals(question5B) && q5B.isChecked()){
                                score++;
                            }else if(question5True.equals(question5C) && q5C.isChecked()){
                                score++;
                            }else if(question5True.equals(question5D) && q5D.isChecked()){
                                score++;
                            }else if(question5True.equals(question5E) && q5E.isChecked()){
                                score++;
                            }

                            if(question6True.equals(question6A) && q6A.isChecked() ){
                                score++;
                            }else if(question6True.equals(question6B) && q6B.isChecked()){
                                score++;
                            }else if(question6True.equals(question6C) && q6C.isChecked()){
                                score++;
                            }else if(question6True.equals(question6D) && q6D.isChecked()){
                                score++;
                            }else if(question6True.equals(question6E) && q6E.isChecked()){
                                score++;
                            }

                            if(question7True.equals(question7A) && q7A.isChecked() ){
                                score++;
                            }else if(question7True.equals(question7B) && q7B.isChecked()){
                                score++;
                            }else if(question7True.equals(question7C) && q7C.isChecked()){
                                score++;
                            }else if(question7True.equals(question7D) && q7D.isChecked()){
                                score++;
                            }else if(question7True.equals(question7E) && q7E.isChecked()){
                                score++;
                            }

                            if(question8True.equals(question8A) && q8A.isChecked() ){
                                score++;
                            }else if(question8True.equals(question8B) && q8B.isChecked()){
                                score++;
                            }else if(question8True.equals(question8C) && q8C.isChecked()){
                                score++;
                            }else if(question8True.equals(question8D) && q8D.isChecked()){
                                score++;
                            }else if(question8True.equals(question8E) && q8E.isChecked()){
                                score++;
                            }

                            if(question9True.equals(question9A) && q9A.isChecked() ){
                                score++;
                            }else if(question9True.equals(question9B) && q9B.isChecked()){
                                score++;
                            }else if(question9True.equals(question9C) && q9C.isChecked()){
                                score++;
                            }else if(question9True.equals(question9D) && q9D.isChecked()){
                                score++;
                            }else if(question9True.equals(question9E) && q9E.isChecked()){
                                score++;
                            }

                            if(question10True.equals(question10A) && q10A.isChecked() ){
                                score++;
                            }else if(question10True.equals(question10B) && q10B.isChecked()){
                                score++;
                            }else if(question10True.equals(question10C) && q10C.isChecked()){
                                score++;
                            }else if(question10True.equals(question10D) && q10D.isChecked()){
                                score++;
                            }else if(question10True.equals(question10E) && q10E.isChecked()){
                                score++;
                            }

                            resultIntent.putExtra("result" , score);
                            startActivity(resultIntent);
                            finish();
                        }
                    }.start();
                    mTimeRunning = true;

                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(mTimeRunning){
                                mCountDownTimer.cancel();
                            }
                            if(question1True.equals(question1A) && q1A.isChecked() ){
                                score++;
                            }else if(question1True.equals(question1B) && q1B.isChecked()){
                                score++;
                            }else if(question1True.equals(question1C) && q1C.isChecked()){
                                score++;
                            }else if(question1True.equals(question1D) && q1D.isChecked()){
                                score++;
                            }else if(question1True.equals(question1E) && q1E.isChecked()){
                                score++;
                            }

                            if(question2True.equals(question2A) && q2A.isChecked() ){
                                score++;
                            }else if(question2True.equals(question2B) && q2B.isChecked()){
                                score++;
                            }else if(question2True.equals(question2C) && q2C.isChecked()){
                                score++;
                            }else if(question2True.equals(question2D) && q2D.isChecked()){
                                score++;
                            }else if(question2True.equals(question2E) && q2E.isChecked()){
                                score++;
                            }

                            if(question3True.equals(question3A) && q3A.isChecked() ){
                                score++;
                            }else if(question3True.equals(question3B) && q3B.isChecked()){
                                score++;
                            }else if(question3True.equals(question3C) && q3C.isChecked()){
                                score++;
                            }else if(question3True.equals(question3D) && q3D.isChecked()){
                                score++;
                            }else if(question3True.equals(question3E) && q3E.isChecked()){
                                score++;
                            }

                            if(question4True.equals(question4A) && q4A.isChecked() ){
                                score++;
                            }else if(question4True.equals(question4B) && q4B.isChecked()){
                                score++;
                            }else if(question4True.equals(question4C) && q4C.isChecked()){
                                score++;
                            }else if(question4True.equals(question4D) && q4D.isChecked()){
                                score++;
                            }else if(question4True.equals(question4E) && q4E.isChecked()){
                                score++;
                            }

                            if(question5True.equals(question5A) && q5A.isChecked() ){
                                score++;
                            }else if(question5True.equals(question5B) && q5B.isChecked()){
                                score++;
                            }else if(question5True.equals(question5C) && q5C.isChecked()){
                                score++;
                            }else if(question5True.equals(question5D) && q5D.isChecked()){
                                score++;
                            }else if(question5True.equals(question5E) && q5E.isChecked()){
                                score++;
                            }

                            if(question6True.equals(question6A) && q6A.isChecked() ){
                                score++;
                            }else if(question6True.equals(question6B) && q6B.isChecked()){
                                score++;
                            }else if(question6True.equals(question6C) && q6C.isChecked()){
                                score++;
                            }else if(question6True.equals(question6D) && q6D.isChecked()){
                                score++;
                            }else if(question6True.equals(question6E) && q6E.isChecked()){
                                score++;
                            }

                            if(question7True.equals(question7A) && q7A.isChecked() ){
                                score++;
                            }else if(question7True.equals(question7B) && q7B.isChecked()){
                                score++;
                            }else if(question7True.equals(question7C) && q7C.isChecked()){
                                score++;
                            }else if(question7True.equals(question7D) && q7D.isChecked()){
                                score++;
                            }else if(question7True.equals(question7E) && q7E.isChecked()){
                                score++;
                            }

                            if(question8True.equals(question8A) && q8A.isChecked() ){
                                score++;
                            }else if(question8True.equals(question8B) && q8B.isChecked()){
                                score++;
                            }else if(question8True.equals(question8C) && q8C.isChecked()){
                                score++;
                            }else if(question8True.equals(question8D) && q8D.isChecked()){
                                score++;
                            }else if(question8True.equals(question8E) && q8E.isChecked()){
                                score++;
                            }

                            if(question9True.equals(question9A) && q9A.isChecked() ){
                                score++;
                            }else if(question9True.equals(question9B) && q9B.isChecked()){
                                score++;
                            }else if(question9True.equals(question9C) && q9C.isChecked()){
                                score++;
                            }else if(question9True.equals(question9D) && q9D.isChecked()){
                                score++;
                            }else if(question9True.equals(question9E) && q9E.isChecked()){
                                score++;
                            }

                            if(question10True.equals(question10A) && q10A.isChecked() ){
                                score++;
                            }else if(question10True.equals(question10B) && q10B.isChecked()){
                                score++;
                            }else if(question10True.equals(question10C) && q10C.isChecked()){
                                score++;
                            }else if(question10True.equals(question10D) && q10D.isChecked()){
                                score++;
                            }else if(question10True.equals(question10E) && q10E.isChecked()){
                                score++;
                            }
                            resultIntent.putExtra("result" , score);
                            startActivity(resultIntent);
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TestResponse>> call, Throwable t) {
                Log.e("Fail" , t.getMessage());
                progressBar.setVisibility(View.GONE);
                mEmptyText.setText("Check Your internet Connection");
                //pause CountDown Timer
                mTimeRunning = false;
            }
        });
    }


}
