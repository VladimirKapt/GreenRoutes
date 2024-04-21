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

public class CreatedRoutesFragment extends Fragment  {
    private List<Part> routes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rated, container, false);

        init();
        RecyclerView routesView = (RecyclerView) view.findViewById(R.id.rectanglerView);
        DemoAdapter routeAdapter = new DemoAdapter(routes);
        routesView.setAdapter(routeAdapter);

        return view;
    }

    // Create test data
    public void init() {
        routes = new ArrayList<>();
        routes.add(new Part("asfd", "Route 1", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 2", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 3", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 4", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 5", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 6", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 7", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 8", "asdfsdaf"));
        routes.add(new Part("asfd", "Route 9", "asdfsdaf"));
    }


}
*/