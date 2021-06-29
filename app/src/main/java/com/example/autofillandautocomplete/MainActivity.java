package com.example.autofillandautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting access to our autocomplete text view
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        // Creating some content for the text view
        List<String> narutoCharacters = new ArrayList<String>() {{
            add("Naruto"); add("Jiraiya"); add("Minato"); add("Rock Lee"); add("Sasuke");
            add("Nina"); add("Noel"); add("Nire");
        }};

        // Creating an ArrayAdapter for our text view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, narutoCharacters);

        // Setting the adapter to our text view
        autoCompleteTextView.setAdapter(arrayAdapter);

        /*
        Setting suggestion threshold to 1 character, meaning now we will get matching suggestions
        for autocomplete when user enters at least 1 character.
        Side Note: We should be careful about this threshold value depending upon the list of
        suggestions content that we have, we should pick a suitable value so that we don't show an
        enormous list of suggestions which hampers the user experience
        */
        autoCompleteTextView.setThreshold(1);
    }
}