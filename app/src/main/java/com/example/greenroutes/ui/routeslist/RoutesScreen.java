package com.example.greenroutes.ui.routeslist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greenroutes.R;
import com.google.android.material.tabs.TabLayout;

public class RoutesScreen extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_routes, container, false);

        TabLayout tabs = view.findViewById(R.id.tabs);
        ViewPager2 pager = view.findViewById(R.id.pager);

        PagerAdapter pagerAdapter = new PagerAdapter(this.getActivity());
        pager.setAdapter(pagerAdapter);

        // Register pressing on tabs
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Switch tabs
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabs.getTabAt(position).select();
                super.onPageSelected(position);
            }
        });

        return view;
    }
}