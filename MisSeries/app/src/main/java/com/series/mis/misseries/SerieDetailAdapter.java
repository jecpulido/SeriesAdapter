package com.series.mis.misseries;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDetail viewHolderDetail, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderDetail extends RecyclerView.ViewHolder {

        public ViewHolderDetail(@NonNull View itemView) {
            super(itemView);
        }
    }
}
