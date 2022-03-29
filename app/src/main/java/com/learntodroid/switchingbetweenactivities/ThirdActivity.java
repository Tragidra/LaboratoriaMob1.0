package com.learntodroid.switchingbetweenactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    TextView receiver_msg;
    Button domoi;
    Button go;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
            Intent intent = new Intent(getApplicationContext(), FileActivity.class);

            startActivity(intent);
        }
                              });
        domoi = findViewById(R.id.domoi);
        domoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        receiver_msg = (TextView) findViewById(R.id.received_value_id);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        str = intent.getStringExtra("6684");

        // display the string into textView
        receiver_msg.setText(str);
        //str = "https://www.youtube.com/results?search_query=" + str;
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
        //startActivity(browserIntent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Приложение Лаборатория 1.0 выключено", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Приложение Лаборатория 1.0 поставлено на паузу", Toast.LENGTH_LONG).show();
        //if (isFinishing()) {
        //Toast.makeText(getApplicationContext(), "Приложение Лаборатория 1.0 выключено", Toast.LENGTH_LONG).show();
        //str = "https://www.google.ru/search?q=" + str;
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
        //startActivity(browserIntent);
        //}

    }
}