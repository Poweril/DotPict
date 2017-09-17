package com.example.houandli.dotpic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void newPic(View view) {
            Intent intent = new Intent(this, activity_edit.class);
            startActivity(intent);
        }
        /*      Alter
        FloatingActionButton newPic = (FloatingActionButton)findViewById(R.id.newPic);
        newPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editNew = new Intent(getApplicationContext(), activity_edit.class);
                startActivity(editNew);
            }
        );*/
}

