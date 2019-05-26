package com.series.mis.misseries;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements EpisodeFragment.OnFragmentInteractionListener {

    public TextView summary,title,subtitle;
    public Spinner season;
    public RecyclerView recycler;
    private ArrayList<DetailSerie> lstDetailSeries;
    private ArrayList<String> lstSeasons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Serie serie = (Serie)getIntent().getExtras().getSerializable("serie");
        title= (TextView) findViewById(R.id.txt_title_episode);
        subtitle = (TextView) findViewById(R.id.txt_subtitle_episode);
        summary = (TextView) findViewById(R.id.txt_resume_serie);
        season = (Spinner) findViewById(R.id.spinner_season);
        recycler = (RecyclerView)findViewById(R.id.recycler_episodes);

        title.setText(serie.getName());
        subtitle.setText(serie.getName());
        summary.setText(R.string.txt_sipnosis);

        findSeasons();

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lstSeasons);
        season.setAdapter(adapterSpinner);
        season.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                char[] season = parent.getSelectedItem().toString().toCharArray();
                String n = "";
                for (int i = 0 ; i<season.length;i++){
                    if (Character.isDigit(season[i])){
                        n += season[i];

                    }
                }
                Log.e("Debug",n);
                fillRecycler(serie,Integer.parseInt(n));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.e("onNothingSelected",""+parent.toString());
            }
        });

        //Llena el recycler
        fillRecycler(serie,1);

        try {
            Glide.with(this).load(serie.getImage()).into((ImageView) findViewById(R.id.img_backSerie));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findSeasons() {
        lstSeasons = new ArrayList<>();
        lstSeasons.add("Temporada 1");
        lstSeasons.add("Temporada 2");
        lstSeasons.add("Temporada 3");
        lstSeasons.add("Temporada 4");
        lstSeasons.add("Temporada 5");
    }

    private void findEpisodes(Serie serie,int season) {
        lstDetailSeries= new ArrayList<>();
        int image = R.drawable.play;

        for (int i = 1; i <= 10;i++){
            String time = "58:12";
            lstDetailSeries.add(
                    new DetailSerie(
                            "T"+season+": "+i+". "+getString(R.string.title_episodes),
                            getString(R.string.txt_sipnosis),
                            time,
                            image));
        }
    }

    private void fillRecycler(Serie serie,int season){

        findEpisodes(serie,season);
        SerieDetailAdapter adapter = new SerieDetailAdapter(lstDetailSeries,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
