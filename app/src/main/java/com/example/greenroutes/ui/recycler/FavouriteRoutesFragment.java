/*
package com.example.greenroutes.ui.recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenroutes.R;
import com.example.greenroutes.ui.domain.Part;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRoutesFragment extends Fragment  {
    private List<Part> favouriteRoutes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rated, container, false);

        init();
        RecyclerView favouritesView = (RecyclerView) view.findViewById(R.id.rectanglerView);
        DemoAdapter routeAdapter = new DemoAdapter(favouriteRoutes);
        favouritesView.setAdapter(routeAdapter);

        return view;
    }

    // Create test data
    public void init() {
        favouriteRoutes = new ArrayList<>();
        favouriteRoutes.add(new Part("Зфыва", "Favourite route 1", "Эывфаe"));
        favouriteRoutes.add(new Part("Зфыва", "Favourite route 2", "Эывфа"));
        favouriteRoutes.add(new Part("Зфыва", "Favourite route 3", "Эывфаe"));
        favouriteRoutes.add(new Part("Зфыва", "Favourite route 4", "Эывфаe"));
    }


}*/
