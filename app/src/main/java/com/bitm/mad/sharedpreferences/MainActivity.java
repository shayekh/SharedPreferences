package com.bitm.mad.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private TextView viewDatTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewDatTV = findViewById(R.id.viewDataTV);

    }

    public void LoadData(View view) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String name = sharedPreferences.getString("Name","N/A");

        int age = sharedPreferences.getInt("age",0);

        viewDatTV.setText(name + ", "+age);


    }

    public void SaveData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("app_user_info",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Name","Android Developer");
        editor.putInt("age",24);

        editor.apply();

    }

    public void goToNext(View view) {
        startActivity(new Intent(MainActivity.this,AnotherActivity.class));
    }

    public void saveNPData(View view) {
        Employee employee = new Employee("Nipon",24,"01401010101");


        Gson gson = new Gson();
        String jsonData = gson.toJson(employee);

        SharedPreferences sharedPreferences = getSharedPreferences("employee_info",MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("employee",jsonData);
        editor.apply();



    }

    public void loadNPData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("employee_info",MODE_PRIVATE);

        String employeeInfo = sharedPreferences.getString("employee","");

        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeInfo,Employee.class);

        viewDatTV.setText(employee.getName()+" " +employee.getAge() +" "+employee.getMobileNum());


    }
}
