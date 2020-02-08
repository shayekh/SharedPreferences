package com.bitm.mad.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private TextView viewDataTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        viewDataTV = findViewById(R.id.viewDataTV);
    }

    public void LoadData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("app_user_info",MODE_PRIVATE);
        String name = sharedPreferences.getString("Name","");
        int age = sharedPreferences.getInt("age",0);

        viewDataTV.setText(name + ", "+age);

    }
}
