package com.nabesh.sqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText fname, lname, email, phoneNumber;
    private RadioButton male, female;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.button);
        submit.setOnClickListener(submitOnClickListener);
    }
    private View.OnClickListener submitOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fname = findViewById(R.id.editText);
            lname = findViewById(R.id.editText1);
            email = findViewById(R.id.editText2);
            phoneNumber = findViewById(R.id.editText3);
            male = findViewById(R.id.radioButton);
            female = findViewById(R.id.radioButton2);
        }
    };
}
