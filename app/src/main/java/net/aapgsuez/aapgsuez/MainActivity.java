package net.aapgsuez.aapgsuez;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import net.aapgsuez.aapgsuez.Blog.BlogActivity;

public class MainActivity extends AppCompatActivity {

    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    private View menu;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private TextView blogText,studyText;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.icon_home:

                        break;

                    case R.id.icon_blog:
                        Intent intent1 = new Intent(MainActivity.this, BlogActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;

                    case R.id.icon_iq_test:
                        Intent intent2 = new Intent(MainActivity.this, IQTestStartActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;


                    case R.id.icon_materials:
                        Intent intent3 = new Intent(MainActivity.this, Mozakra.class);
                        intent3.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;

                }


                return false;
            }
        });

//        menu = findViewById(R.id.bg_fab_menu);
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isFabOpen==true) {
//                    fab.startAnimation(rotate_backward);
//                    fab1.startAnimation(fab_close);
//                    fab1.setClickable(false);
//                    fab2.startAnimation(fab_close);
//                    blogText.startAnimation(fab_close);
//                    studyText.startAnimation(fab_close);
//                    fab2.setClickable(false);
//                    isFabOpen = false;
//                    menu.setVisibility(View.GONE);
//                }
//            }
//        });
//        fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
//        fab2=(FloatingActionButton)findViewById(R.id.fab2);
//        blogText=(TextView)findViewById(R.id.blog_text);
//        studyText=(TextView)findViewById(R.id.study_text);
//        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
//        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
//        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
//        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                animateFAB();
//            }
//        });
//
//
////        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabb);
//        fab1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), Mozakra.class);
//                startActivity(i);
//            }
//        });
//
//        fab2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), BlogActivity.class);
//                startActivity(i);
//            }
//        });
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (isFabOpen == true) {
//            fab.startAnimation(rotate_backward);
//            fab1.startAnimation(fab_close);
//            fab2.startAnimation(fab_close);
//            studyText.startAnimation(fab_close);
//            blogText.startAnimation(fab_close);
//            isFabOpen = false;
//            menu.setVisibility(View.GONE);
//        }
//    }
//
//
//    public void animateFAB(){
//
//        if(isFabOpen){
//
//            fab.startAnimation(rotate_backward);
//            fab1.startAnimation(fab_close);
//            fab1.setClickable(false);
//            fab2.startAnimation(fab_close);
//            fab2.setClickable(false);
//            blogText.startAnimation(fab_close);
//            studyText.startAnimation(fab_close);
//            isFabOpen = false;
//            menu.setVisibility(View.GONE);
//
//        } else {
//
//            fab.startAnimation(rotate_forward);
//            fab1.startAnimation(fab_open);
//            fab1.setClickable(true);
//            fab2.startAnimation(fab_open);
//            fab2.setClickable(true);
//            blogText.startAnimation(fab_open);
//            studyText.startAnimation(fab_open);
//            menu.setVisibility(View.VISIBLE);
//            isFabOpen = true;
//
//        }
    }

    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
            finish();
        }
        else { Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        recreate();


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    HomeFragment homeFragment = new HomeFragment();
                    return homeFragment;
                case 1:
                    EventsFragment pastFragment = new EventsFragment();
                    return pastFragment;
                case 2:
                    ArticlesFragment scientificFragment = new ArticlesFragment();
                    return scientificFragment;

                case 3:
                    MagazineFragment magazineFragment = new MagazineFragment();
                    return magazineFragment;

                case 4:
                    GpaCalc gpaCalc = new GpaCalc();
                    return gpaCalc;
                case 5:
                    Petroleum_price petroleum_price = new Petroleum_price();
                    return petroleum_price;


                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "AAPG Quotes";
                case 1:
                    return "Events";
                case 2:
                    return "Scientific Articles";

                case 3:
                    return "Magazines";

                case 4:
                    return "GPA Calc";
                case 5:
                    return "Petroleum Price";

            }
            return null;
        }
    }
}
