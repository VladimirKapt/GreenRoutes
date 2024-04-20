package com.example.greenroutes.ui.routeslist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.greenroutes.R;
import com.example.greenroutes.domain.Route;
import com.example.greenroutes.ui.routeslist.recycler.RouteAdapter;
import com.example.greenroutes.ui.routeslist.recycler.RouteClickListener;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRoutesFragment extends Fragment implements RouteClickListener {
    private List<Route> favouriteRoutes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite_routes, container, false);

        init();
        RecyclerView favouritesView = (RecyclerView) view.findViewById(R.id.favourite_routes_view);
        RouteAdapter routeAdapter = new RouteAdapter(favouriteRoutes, this);
        favouritesView.setAdapter(routeAdapter);

        return view;
    }

    // Create test data
    public void init() {
        favouriteRoutes = new ArrayList<>();
        favouriteRoutes.add(new Route(0L, "Favourite route 1", 32, false));
        favouriteRoutes.add(new Route(1L, "Favourite route 2", 25, true));
        favouriteRoutes.add(new Route(2L, "Favourite route 3", 30, false));
        favouriteRoutes.add(new Route(3L, "Favourite route 4", 10, false));
    }

    // Custom onClick() logic
    @Override
    public void onClick(int position) {
        Toast.makeText(this.getContext(), "Opening " + favouriteRoutes.get(position), Toast.LENGTH_SHORT).show();
    }
}