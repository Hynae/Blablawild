package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);


        Intent intent2 = getIntent();
        String Departure = intent2.getStringExtra("Departure");
        String Destination = intent2.getStringExtra("Destination");
        setTitle(Departure + " >> " + Destination);
    }
}
