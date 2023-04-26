package com.example.picture_match_puzzel.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.picture_match_puzzel.Adapters.lavel_adapter;
import com.example.picture_match_puzzel.R;

public class normal_activity extends AppCompatActivity {

    GridView gridView;
    Button button;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        button=findViewById(R.id.warning_button2);

        gridView=findViewById(R.id.normal_grid_view);
        lavel_adapter lavelAdapter=new lavel_adapter(normal_activity.this, preferences);
        gridView.setAdapter(lavelAdapter);
        preferences=getSharedPreferences("pre",MODE_PRIVATE);
        editor= preferences.edit();
        editor.putString("status","normal");
        editor.commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(normal_activity.this);
                builder.setTitle("How To Play match 1");
                builder.setMessage("Tap on a square to turn it over and see the"+"\n"+" picture it hides."
                +"\n \n"+"Tap ao another square to turn it over too."
                +"\n \n"+"if the picture match,they'll stay facing up, if not,"+"\n"+"both will turn over again."
                +"\n \n"+"Find all couples.");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });
    }
}