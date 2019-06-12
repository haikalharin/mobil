package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class Menu2Activity extends AppCompatActivity {

    public static final int REQUEST_CODE =1;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
    final ArrayList<Home> homes = new ArrayList<>();

        homes.add(new Home("MOBIL A terbaru versi 1",
                R.drawable.a1, 100000000, "Type R", "Dijual cepat mobil ini keadan buruk",
                "08986948747"));
        homes.add(new Home("MOBIL B terbaru versi 1",
                R.drawable.a2, 150000000, "Type R", "Dijual cepat mobil ini keadan baik",
                "08123423432"));
        homes.add(new Home("MOBIL C terbaru versi 1",
                R.drawable.a3, 170000000, "Type R", "Dijual cepat mobil ini keadan bagus",
                "08342848248"));
        homes.add(new Home("MOBIL D terbaru versi 1",
                R.drawable.a4, 180000000, "Type R", "Dijual cepat mobil ini keadan mulus",
                "08345334934"));
        homes.add(new Home("MOBIL F terbaru versi 1",
                R.drawable.a5, 190000000, "Type R", "Dijual cepat mobil ini keadan apa adanya",
                "08675645445"));
        homes.add(new Home("MOBIL G terbaru versi 1",
                R.drawable.a6, 200000000, "Type R", "Dijual cepat mobil ini keadan sangat baik",
                "08342123454"));

        adapter = new  HomeAdapter(this,homes);

        ListView orderListView = (ListView)
        findViewById(R.id.order_list_view);
                orderListView.setAdapter(adapter);
                orderListView.setOnItemClickListener(new
                AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(Menu2Activity.this, HomeDetailActivity.class);

                        Home currentHome = homes.get(position);
                        Log.e("HOME NAME", currentHome.getHomeName());
                        i.putExtra("name", currentHome.getHomeName());
                        i.putExtra("image", currentHome.getmImageResouce());
                        i.putExtra("price", currentHome.getHomePrice());
                        i.putExtra("type", currentHome.getType());
                        i.putExtra("deskripsi", currentHome.getHomeDescription());
                        i.putExtra("telfon", currentHome.getTelfon());
                        startActivity(i);

                    }
                });


    }
}
