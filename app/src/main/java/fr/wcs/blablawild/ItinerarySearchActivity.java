package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ItinerarySearchActivity extends AppCompatActivity {
    private static final String TAG = "ItinerarySearchActivity";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        mDisplayDate = findViewById(R.id.text_Date);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ItinerarySearchActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        };
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
