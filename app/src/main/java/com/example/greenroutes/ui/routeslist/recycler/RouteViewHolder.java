package com.example.greenroutes.ui.routeslist.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.greenroutes.R;
import com.example.greenroutes.domain.Route;

public class RouteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView routeName;
    private final ImageView checkmark;
    private final TextView routeLength;
    private final RouteClickListener routeClickListener;

    public RouteViewHolder(View view, RouteClickListener routeClickListener) {
        super(view);
        this.routeName = view.findViewById(R.id.route_name);
        this.checkmark = view.findViewById(R.id.checkmark);
        this.routeLength = view.findViewById(R.id.route_length);
        this.routeClickListener = routeClickListener;

        view.setOnClickListener(this);
    }

    // Put the data from Route into the view
    public void bind(Route route) {
        routeName.setText(route.getName());
        if (route.isCompleted()) {
            checkmark.setVisibility(View.VISIBLE);
        }
        routeLength.setText(route.getLength() + " km");
    }

    // Tie custom onClick() with standard onClick()
    @Override
    public void onClick(View v) {
        routeClickListener.onClick(getAdapterPosition());
    }
}
