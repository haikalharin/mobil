package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;




public class HomeDetailActivity extends AppCompatActivity {

    private int item = 0;
    TextView sumTextView;
    TextView priceTotalTextView;
    private int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);

        String name = getIntent().getStringExtra("name");
        String typs = getIntent().getStringExtra("type");
        String desc = getIntent().getStringExtra("deskripsi");
        final String telf = getIntent().getStringExtra("telfon");

        int image;
        image = getIntent().getIntExtra("image", -1);
        price = getIntent().getIntExtra("price", -1);


        Log.e("SECOND ACTIVITY", name);

        TextView nameTextView = (TextView)
                findViewById(R.id.home_name_text_view);
        nameTextView.setText(name);

        TextView type = (TextView)
                findViewById(R.id.type);
        type.setText(typs);

        TextView deskripsi = (TextView)
                findViewById(R.id.judul_deskripsi);
        deskripsi.setText(desc);

        TextView telfon = (TextView)
                findViewById(R.id.no_telfon);
        telfon.setText(telf);

        ImageView imageView = (ImageView)
                findViewById(R.id.home_image);
        imageView.setImageResource(image);
        imageView.setVisibility(View.VISIBLE);

        TextView priceTextView = (TextView)
                findViewById(R.id.price_detail_text_view);
        priceTextView.setText(Integer.toString(price));

        sumTextView = (TextView)
                findViewById(R.id.sum_text_view);

        priceTotalTextView = (TextView)
                findViewById(R.id.price_total_text_view);

        Button incrementBotton = (Button)
                findViewById(R.id.increment_button);
        incrementBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();

            }
        });

        Button decrementBotton = (Button)
                findViewById(R.id.decrement_button);
        decrementBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();

            }
        });

        Button pesan = (Button)
                findViewById(R.id.order_button);
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeDetailActivity.this);
                builder.setMessage("Terima Kasih ! \nAnda akan dihubungi oleh pihak Dealer dalam 15 menit setelah pemesanan")
                        .setNegativeButton("OK", null).create().show();

            }


        });

        Button panggil_button=(Button)
                findViewById(R.id.panggil_button);
        panggil_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView=(TextView)
                        findViewById(R.id.no_telfon);
                Intent call = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+textView.getText()));
                startActivity(call);
            }
        });


    }
    private void increment() {
        item++;
        sumTextView.setText(Integer.toString(item));

        priceTotalTextView.setText(Integer.toString(sumOfProduct(price)));
    }

    private void decrement() {
        if (item > 0) {
            item--;
        }
        sumTextView.setText(Integer.toString(item));

        priceTotalTextView.setText(Integer.toString(sumOfProduct(price)));

    }

    private int sumOfProduct(int price) {
        return item * price;
    }

    public void panggil(View view) {
    }
}