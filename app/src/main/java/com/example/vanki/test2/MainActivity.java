package com.example.vanki.test2;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        final TabLayout.Tab around = tabLayout.newTab();
        final TabLayout.Tab map = tabLayout.newTab();

//        around.setText("Around");
//        map.setText("Map");

        View aroundView = getLayoutInflater().inflate(R.layout.custom_tablayout,null);
        final ImageView around_image = aroundView.findViewById(R.id.img_tab);
        TextView around_text = aroundView.findViewById(R.id.txt_name);
        around_image.setImageResource(R.drawable.around);
        around_text.setText("Around");

        View mapView = getLayoutInflater().inflate(R.layout.custom_tablayout,null);
        final ImageView img_map = mapView.findViewById(R.id.img_tab);
        TextView txt_map = mapView.findViewById(R.id.txt_name);
        img_map.setImageResource(R.drawable.around);
        txt_map.setText("Map");

        around.setCustomView(aroundView);
        map.setCustomView(mapView);

        tabLayout.addTab(around,0);
        tabLayout.addTab(map,1);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        around_image.setImageResource(R.drawable.around_selected);
                        img_map.setImageResource(R.drawable.around);
                        break;
                    case 1:
                        img_map.setImageResource(R.drawable.around_selected);
                        around_image.setImageResource(R.drawable.around);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
