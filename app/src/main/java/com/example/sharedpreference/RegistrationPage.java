package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationPage extends AppCompatActivity {
    EditText etextname,etextaddress,etextage;
    Button savebutton;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_AGE = "age";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        etextname=(EditText) findViewById(R.id.txtName);
        etextaddress=(EditText)findViewById(R.id.txtAddress);
        etextage=(EditText)findViewById(R.id.txtAge);
        savebutton=(Button)findViewById(R.id.btn);

        sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);

        if (name != null){
            Intent intent = new Intent(RegistrationPage.this,MainActivity.class);
           startActivity(intent);
        }

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,etextname.getText().toString());
                editor.putString(KEY_ADDRESS,etextaddress.getText().toString());
                editor.putString(KEY_AGE,etextage.getText().toString());
                editor.apply();
                Intent intent = new Intent(RegistrationPage.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
}
