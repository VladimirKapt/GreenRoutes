package com.example.greenroutes.ui.routeslist.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenroutes.R;
import com.example.greenroutes.domain.Route;

import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteViewHolder> {
    private final List<Route> routes;
    private final RouteClickListener routeClickListener;

    public RouteAdapter(List<Route> routes, RouteClickListener routeClickListener) {
        this.routes = routes;
        this.routeClickListener = routeClickListener;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_route, parent, false);
        return new RouteViewHolder(view, routeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {
        holder.bind(routes.get(position)); // Show data from Route in the view
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }
}
