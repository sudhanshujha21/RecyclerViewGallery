package com.example.himmanshoojha.recyclerviewgallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Himmanshoo Jha on 20/03/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    public MyViewHolder(View itemView) {
        super(itemView);
        img = (ImageView)itemView.findViewById(R.id.imgh);
    }
}
