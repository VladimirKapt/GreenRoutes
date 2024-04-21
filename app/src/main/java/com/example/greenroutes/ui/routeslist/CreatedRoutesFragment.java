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

public class CreatedRoutesFragment extends Fragment implements RouteClickListener {
    private List<Route> routes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_created_routes, container, false);

        init();
        RecyclerView routesView = (RecyclerView) view.findViewById(R.id.created_routes_view);
        RouteAdapter routeAdapter = new RouteAdapter(routes, this);
        routesView.setAdapter(routeAdapter);

        return view;
    }

    // Create test data
    public void init() {
        routes = new ArrayList<>();
        routes.add(new Route(0L, "Route 1", 32, false));
        routes.add(new Route(1L, "Route 2", 25, true));
        routes.add(new Route(2L, "Route 3", 30, false));
        routes.add(new Route(3L, "Route 4", 10, false));
        routes.add(new Route(4L, "Route 5", 23, false));
        routes.add(new Route(5L, "Route 6", 6, false));
        routes.add(new Route(6L, "Route 7", 52, false));
        routes.add(new Route(7L, "Route 8", 34, false));
        routes.add(new Route(8L, "Route 9", 48, false));
    }

    // Custom onClick() logic
    @Override
    public void onClick(int position) {
        Toast.makeText(this.getContext(), "Opening " + routes.get(position), Toast.LENGTH_SHORT).show();
    }
}