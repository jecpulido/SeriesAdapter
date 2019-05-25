package com.series.mis.misseries;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SerieDetailAdapter extends RecyclerView.Adapter<SerieDetailAdapter.ViewHolderDetail>{

    public ArrayList<DetailSerie> lstRequest;
    public Context vContext;

    public SerieDetailAdapter(ArrayList<DetailSerie> lstRequest, Context vContext) {
        this.lstRequest = lstRequest;
        this.vContext = vContext;
    }

    @Override
    public ViewHolderDetail onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_episode,null,false);
        return new ViewHolderDetail(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDetail viewHolderDetail, int i) {
        final DetailSerie detailSerie = lstRequest.get(i);
        Log.e("Debug",detailSerie.getName());
        viewHolderDetail.image.setImageResource(detailSerie.getImage());
        viewHolderDetail.time.setText(detailSerie.getDuracion());
        viewHolderDetail.title.setText(detailSerie.getName());
        viewHolderDetail.sipnosis.setText(detailSerie.getSynopsis());
    }

    @Override
    public int getItemCount() {
        return this.lstRequest.size();
    }

     public class ViewHolderDetail extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView title,sipnosis,time;

        public ViewHolderDetail(@NonNull View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.img_episode);
            title= (TextView) itemView.findViewById(R.id.txt_title_episodes);
            sipnosis=(TextView) itemView.findViewById(R.id.txt_sipnosis);
            time =(TextView) itemView.findViewById(R.id.txt_time);

        }
    }
}
