package com.series.mis.misseries;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.ViewHolderSerie> {

    public ArrayList<Serie> lstSeries;
    public Context vContext;

    public SerieAdapter(ArrayList<Serie> lstSeries, Context vContext) {
        this.lstSeries = lstSeries;
        this.vContext = vContext;
    }

    @Override
    public SerieAdapter.ViewHolderSerie onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_serie,null,false);
        return new ViewHolderSerie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieAdapter.ViewHolderSerie viewHolderSerie, int i) {
        final Serie serie = lstSeries.get(i);
        viewHolderSerie.image.setImageResource(serie.getImage());
        viewHolderSerie.image.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Transition transition = new Slide(Gravity.TOP);
                transition.setDuration(1000);
                transition.setInterpolator(new DecelerateInterpolator());
                ((MainActivity) vContext).getWindow().setExitTransition(transition);
                Intent intent = new Intent(vContext,DetailActivity.class);
                intent.putExtra("serie",serie);
                vContext.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity)vContext).toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstSeries.size();
    }

    public class ViewHolderSerie extends RecyclerView.ViewHolder {

        ImageView image;

        public ViewHolderSerie(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_view_serie);
        }
    }
}

