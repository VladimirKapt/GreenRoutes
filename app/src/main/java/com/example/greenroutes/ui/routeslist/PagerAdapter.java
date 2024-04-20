package com.example.greenroutes.ui.routeslist;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {
    private final int tabCount = 2;
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new FavouriteRoutesFragment();
            default:
                return new CreatedRoutesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
