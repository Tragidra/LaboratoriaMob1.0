package com.learntodroid.switchingbetweenactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstActivity extends AppCompatActivity {
    Button switchToSecondActivity;
    static final String DB_URL = "jdbc:postgresql:http://127.0.0.1:8000/Laboratoria";
    static final String USER = "postgres";
    static final String PASS = "astrafaz99";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        switchToSecondActivity = findViewById(R.id.activity_first_button);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
//                switchActivitiesWithData();
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, SecondActivity.class);
        startActivity(switchActivityIntent);
    }

    @Override
    protected void onPause() {

        super.onPause();
        Toast.makeText(getApplicationContext(), "Приложение Лаборатория 1.0 поставлено на паузу", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {

        super.onResume();
        Toast.makeText(getApplicationContext(), "Приложение Лаборатория 1.0 продолжило свою работу", Toast.LENGTH_LONG).show();

    }

    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Приложение Лаборатория 1.0 завершило свою работу", Toast.LENGTH_LONG).show();

    }

    private void switchActivitiesWithData() {
        Intent switchActivityIntent = new Intent(this, SecondActivity.class);
        switchActivityIntent.putExtra("message", "From: " + FirstActivity.class.getSimpleName());
        startActivity(switchActivityIntent);
    }
}
