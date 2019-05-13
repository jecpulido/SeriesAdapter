package com.series.mis.misseries;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.ViewHolderSerie> {

    public ArrayList<Serie> lstRequest;
    public Context vContext;

    public SerieAdapter(ArrayList<Serie> lstRequest, Context vContext) {
        this.lstRequest = lstRequest;
        this.vContext = vContext;
    }

    @Override
    public SerieAdapter.ViewHolderSerie onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SerieAdapter.ViewHolderSerie viewHolderSerie, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderSerie extends RecyclerView.ViewHolder {
        public ViewHolderSerie(@NonNull View itemView) {
            super(itemView);
        }
    }
}

