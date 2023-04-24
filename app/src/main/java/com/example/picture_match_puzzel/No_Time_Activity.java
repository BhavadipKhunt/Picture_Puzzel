package com.example.picture_match_puzzel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class No_Time_Activity extends AppCompatActivity {

        GridView gridView;
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_time);
        gridView=findViewById(R.id.no_time_grid_view);
        button=findViewById(R.id.warning_button1);
        lavel_adapter lavelAdapter=new lavel_adapter(No_Time_Activity.this);
        gridView.setAdapter(lavelAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(No_Time_Activity.this,level_play_activity.class);
                startActivity(intent);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(No_Time_Activity.this);
                builder.setTitle("How To Play Match 1");
                builder.setMessage("Tap on a square to turn it over and see the"+"\n"+" picture it hides."
                        +"\n \n"+"Tap on another square to turn it over too."
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