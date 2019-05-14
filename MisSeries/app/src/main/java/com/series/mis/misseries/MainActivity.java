package com.series.mis.misseries;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private ArrayList<Serie> lstSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.recycler_series);
        loadSeries();

        SerieAdapter adapter = new SerieAdapter(lstSeries,this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recycler.setLayoutManager(mLayoutManager);
        recycler.addItemDecoration(new GridSpacingItemDecoration(2 , dpToPx(5), true));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
    }

    private void loadSeries() {
        lstSeries = new ArrayList<>();
        lstSeries.add(new Serie("Black Mirror",R.drawable.serie_1));
        lstSeries.add(new Serie("Dark",R.drawable.serie_2));
        lstSeries.add(new Serie("Friends",R.drawable.serie_3));
        lstSeries.add(new Serie("House of Cards",R.drawable.serie_4));
        lstSeries.add(new Serie("Lucifer",R.drawable.serie_5));
        lstSeries.add(new Serie("Narcos",R.drawable.serie_6));
        lstSeries.add(new Serie("Rick and Morty",R.drawable.serie_7));
        lstSeries.add(new Serie("Stranger Things",R.drawable.serie_8));
        lstSeries.add(new Serie("Vikingos",R.drawable.serie_9));
        lstSeries.add(new Serie("The Walking Dead",R.drawable.serie_10));
    }


    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}
