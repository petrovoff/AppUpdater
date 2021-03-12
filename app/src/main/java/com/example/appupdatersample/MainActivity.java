package com.example.appupdatersample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Model model = new Model();
        String json = new Gson().toJson(model);
        Log.d("TEST123", "onCreate: " + json);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            new AppUpdater(this)
                    .setUpdateFrom(UpdateFrom.JSON)
                    .setUpdateJSON("https://run.mocky.io/v3/aa820032-d110-4870-b13f-994e7e82d909")
                    .start();

        });

    }
}