package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.List;
import static android.R.attr.resource;

public class HomeAdapter extends ArrayAdapter<Home> {

    public HomeAdapter(Activity context, ArrayList<Home>homes) {
        super(context, 0, homes);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item,
                    parent, false);
        }
        Home currentHome = getItem(position);

        TextView homeNameTextView =  (TextView)
                listItemView.findViewById(R.id.home_name_text_view);
        homeNameTextView.setText(currentHome.getHomeName());

        TextView priceTextView = (TextView)
                listItemView.findViewById(R.id.price_text_view);
        priceTextView.setText(Integer.toString(currentHome.getHomePrice()));

        ImageView imageView = (ImageView)
                listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentHome.getmImageResouce());
        imageView.setVisibility((View.VISIBLE));
        return listItemView;

    }
}

//Ini digunakan untuk menyambungkan ke list_item