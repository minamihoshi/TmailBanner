package com.minami.lnx.tmailbanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private MyPagerAdapter myPagerAdapter ;
    private List<Fragment> list ;
    interface BannerInterface {

        void onClick(View view ,int position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ViewPager viewPager = findViewById(R.id.viewpager);
        final TextView tv = findViewById(R.id.tv);
        final TextView tv_video = findViewById(R.id.tv_video);
        final TextView tv_image = findViewById(R.id.tv_image);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        list  = new ArrayList<>();
        list.add(new BlankFragment());


        BannerInterface bannerInterface = new BannerInterface() {
            @Override
            public void onClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_main:
                        Toast.makeText(Main2Activity.this, "aaaa" + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_main:
                        Toast.makeText(Main2Activity.this, "bbbb" + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        for (int i = 0; i < 4; i++) {
            list.add(SecondFragment.newInstance(i).setBannerInterface(bannerInterface));
        }
        myPagerAdapter = new MyPagerAdapter(supportFragmentManager,list);
        viewPager.setAdapter(myPagerAdapter);


        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                Log.e("TAG", "onClick: " + currentItem );

                Toast.makeText(Main2Activity.this , currentItem+"" ,Toast.LENGTH_SHORT).show();
            }
        });



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    tv.setVisibility(View.GONE);
                    tv_video.setVisibility(View.VISIBLE);
                    tv_video.setSelected(true);
                    tv_image.setSelected(false);
                    tv_image.setVisibility(View.GONE);
                }else {
                    int max =list.size() -1 ;
                    tv.setVisibility(View.VISIBLE);
                    tv.setText(position +"/" +max);
                    tv_video.setSelected(false);
                    tv_image.setSelected(true);

                    tv_video.setVisibility(View.GONE);
                    tv_image.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
