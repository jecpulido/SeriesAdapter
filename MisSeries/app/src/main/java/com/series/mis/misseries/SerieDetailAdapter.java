package com.series.mis.misseries;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SerieDetailAdapter extends RecyclerView.Adapter<SerieDetailAdapter.ViewHolderDetail>{

    public ArrayList<DetailSerie> lstRequest;
    public Context vContext;
    private FrameLayout fragmentContainer;

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
        fragmentContainer = (FrameLayout) ((DetailActivity)vContext).findViewById(R.id.fragment_detail);
        viewHolderDetail.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(detailSerie);
            }
        });
    }

    public void openFragment(DetailSerie serie) {
        EpisodeFragment fragment = EpisodeFragment.newInstance(serie);
        FragmentManager fragmentManager = ((DetailActivity)vContext).getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_detail, fragment, "BLANK_FRAGMENT").commit();
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
