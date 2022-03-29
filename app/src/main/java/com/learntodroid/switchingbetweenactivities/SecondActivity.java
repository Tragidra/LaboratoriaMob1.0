package com.learntodroid.switchingbetweenactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class SecondActivity extends AppCompatActivity {
    Button backButton;
    TextView result;
    Button send_button;
    EditText send_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        send_button = (Button)findViewById(R.id.send_button_id1);
        send_text = (EditText)findViewById(R.id.send_text_id1);

        backButton = findViewById(R.id.activity_second_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String str = send_text.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("6684", str);

                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        MediaPlayer mp = new MediaPlayer();
        String path = "/storage/emulated/0/Download/F1 - (Brian Tyler - Formula 1 2018 Theme)_(newmp3.org).mp3";
        String fileName = "F1 - (Brian Tyler - Formula 1 2018 Theme)_(newmp3.org)";

        try {
            mp.setDataSource(path + File.separator + fileName);
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void retrieveMessage() {
        result = findViewById(R.id.activity_second_result);
        result.setText(getIntent().getStringExtra("message"));
    }
}
