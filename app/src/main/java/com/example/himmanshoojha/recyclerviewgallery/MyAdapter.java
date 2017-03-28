package com.example.himmanshoojha.recyclerviewgallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by Himmanshoo Jha on 20/03/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context cnt;
    ArrayList<Imagegallery> image_galleries;

    public MyAdapter(Context cnt,ArrayList<Imagegallery> image_galleries){
        this.cnt=cnt;
        this.image_galleries=image_galleries;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(cnt).inflate(R.layout.gallery_rowhv,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Imagegallery ig =image_galleries.get(position);
        Picasso.with(cnt).load(ig.getUri()).placeholder(R.drawable.image_placeholder).into( holder.img);

    }

    @Override
    public int getItemCount() {
        return image_galleries.size();
    }
}
