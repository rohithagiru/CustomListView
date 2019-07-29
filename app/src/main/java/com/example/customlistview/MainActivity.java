package com.example.customlistview;


import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    private ListView listView;
    private String carNames[] = {
            "Camero",
            "Mustang",
            "Charger",
            "XJL"
    };

    private String carMake[] = {
            "Chevy",
            "Ford",
            "Dodge",
            "Jaguar"
    };


    private Integer imageid[] = {
            R.drawable.camero,
            R.drawable.mustang,
            R.drawable.charger,
            R.drawable.jag

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting header
        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List of Cars");

        ListView listView=(ListView)findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        CustomCar customCountryList = new CustomCar(this, carNames, carMake, imageid);
        listView.setAdapter(customCountryList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"You Selected "+ carNames[position-1]+ " as Car",Toast.LENGTH_SHORT).show();        }
        });
    }
}