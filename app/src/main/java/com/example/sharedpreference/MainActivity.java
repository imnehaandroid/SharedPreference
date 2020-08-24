package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textName,textAddress,textAge,currentTime;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_AGE = "age";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName =(TextView)findViewById(R.id.txt_name);
        textAddress=(TextView)findViewById(R.id.txt_address);
        textAge=(TextView)findViewById(R.id.txt_age);
        currentTime= (TextView)findViewById(R.id.currentTime);

        sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);

        SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
        currentTime.setText(currentDateandTime);

        String name = sharedPreferences.getString(KEY_NAME,null);
        String address = sharedPreferences.getString(KEY_ADDRESS,null);
        String age = sharedPreferences.getString(KEY_AGE,null);

        if (name != null || address != null || age != null){
            textName.setText("Full Name  = "+name);
            textAddress.setText("Address = "+address);
            textAge.setText("Age = "+age);
        }




    }
}
