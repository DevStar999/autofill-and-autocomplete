package com.example.autofillandautocomplete;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting access to our autocomplete text view
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_complete_textview);

        // Creating some content for the text view
        List<String> narutoCharacters = new ArrayList<String>() {{
            add("Naruto");
            add("Jiraiya");
            add("Minato");
            add("Rock Lee");
            add("Sasuke");
            add("Nina");
            add("Noel");
            add("Nire");
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

/*
Note on Autofill: Some apps have the ability to fill in the edit texts of other apps and websites,
and we can have only 1 default app that can does this at a time. Like 99% of the times, it's going
to be a password manager. Android has explicitly stated in their documentation that if we are using
this technology then most likely we are a password manager. But, the relevance that this has with
any app that we build is that we should be able to work with this password manager smoothly so as to
provide a good user experience. With the attribute for the view - android:autofillHints, we can tell
this password manager app that we want what type of a value for this edit text for e.g. If the view
is to fill up a username, then we set the value of this attribute as follows -
android:autofillHints="AUTOFILL_HINT_USERNAME"
*/