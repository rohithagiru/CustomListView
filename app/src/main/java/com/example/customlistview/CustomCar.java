package com.example.customlistview;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomCar extends ArrayAdapter {
    private String[] carName;
    private String[] csrMake;
    private Integer[] imageid;
    private Activity context;

    public CustomCar(Activity context, String[] carName, String[] carMake, Integer[] imageid) {
        super(context, R.layout.row_item, carName);
        this.context = context;
        this.carName = carName;
        this.csrMake = carMake;
        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewCountry = (TextView) row.findViewById(R.id.textViewCarName);
        TextView textViewCapital = (TextView) row.findViewById(R.id.textViewCarMake);
        ImageView imageFlag = (ImageView) row.findViewById(R.id.imageViewCar);

        textViewCountry.setText(carName[position]);
        textViewCapital.setText(csrMake[position]);
        imageFlag.setImageResource(imageid[position]);
        return  row;
    }
}