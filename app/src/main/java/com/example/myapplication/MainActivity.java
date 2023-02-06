package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ViewpagerItemBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ArrayList<ViewPagerItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        int[] images = {R.drawable.pancake, R.drawable.fruit_smoothies};
        String[] headings = {"Pancake", "Fruity Smoothies"};
        String[] details = {getString(R.string.pancake_description),
                getString(R.string.fruit_smoothies_description)};

        arrayList = new ArrayList<>();
        for (int i = 0; i < images.length; i++)
            arrayList.add(new ViewPagerItem(images[i],headings[i], details[i]));

        VPAdapter vpAdapter = new VPAdapter(arrayList);
        viewPager2.setAdapter(vpAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("")
        ).attach();
    }
}