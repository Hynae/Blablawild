package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
    }

    public void onClick(View view) {

        EditText text_Departure = findViewById(R.id.text_Departure);
        EditText text_Destination = findViewById(R.id.text_Destination);
        EditText text_date = findViewById(R.id.text_Date);
        String DepartureValue = text_Departure.getText().toString();
        String DestinationValue = text_Destination.getText().toString();
        String DateValue = text_date.getText().toString();

        if (DestinationValue.equals("") || DepartureValue.isEmpty()) {
            Toast.makeText(ItinerarySearchActivity.this, R.string.toastText, Toast.LENGTH_LONG).show();

        } else {
            Intent intent2 = new Intent(ItinerarySearchActivity.this,ItineraryListActivity.class);
            intent2.putExtra("Departure",text_Departure.getText().toString());
            intent2.putExtra("Destination",text_Destination.getText().toString());
            startActivity(intent2);



        }
        setTitle("Search");
    }


}
