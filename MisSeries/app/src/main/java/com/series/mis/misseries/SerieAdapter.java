package com.series.mis.misseries;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vContext, DetailActivity.class);
                intent.putExtra("serie",serie);
                vContext.startActivity(intent);
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

