package com.arief.utsmobileprogramming;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import static android.R.attr.resource;

/**
 * Created by arif1 on 11/1/2016.
 */

public class KueAdapter extends ArrayAdapter<String> {

    private final AppCompatActivity context;
    private final String[] NamaKue;
    private final int[] GbrKue;


    public KueAdapter(AppCompatActivity context,String[] NamaKue, int[] GbrKue) {
        super(context, R.layout.list_kue, NamaKue);

        this.context = context;
        this.NamaKue = NamaKue;
        this.GbrKue = GbrKue;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_kue, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(NamaKue[position]);
        imageView.setImageResource(GbrKue[position]);

        return rowView;
    }
}
