/*
package com.example.greenroutes.ui.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenroutes.R;
import com.example.greenroutes.ui.domain.Part;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoVH> {
    private List<Part> items;

    public DemoAdapter(List<Part> items){
        this.items=items;
    }

    @NonNull
    @Override
    public DemoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new DemoVH(view);//.linkAdapter(this)

    }


    @Override
    public void onBindViewHolder(@NonNull DemoVH holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class DemoVH extends RecyclerView.ViewHolder {
    TextView name;
    TextView path;
    TextView points;
    DemoAdapter adapter;

    public DemoVH(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        path = itemView.findViewById(R.id.path);
        points = itemView.findViewById(R.id.points);

    }


    public DemoVH linkAdapter(DemoAdapter adapter) {
        this.adapter = adapter;
        return this;
    }
    public void bind(Part xyu) {
        name.setText(xyu.getName());
        path.setText(xyu.getPath());
        points.setText(xyu.getPoint());
    }

}





*/
