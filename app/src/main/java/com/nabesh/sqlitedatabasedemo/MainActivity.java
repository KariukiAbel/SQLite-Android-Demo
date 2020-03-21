package com.nabesh.sqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText fname, lname, email, phoneNumber;
    private RadioButton male, female;
    private Button submit;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.editText);
        lname = findViewById(R.id.editText1);
        email = findViewById(R.id.editText2);
        phoneNumber = findViewById(R.id.editText3);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);

        if (male.isSelected()){
            gender = male.getText().toString();
        }else {
            gender = female.getText().toString();
        }

        submit = findViewById(R.id.button);
        submit.setOnClickListener(submitOnClickListener);
    }
    private View.OnClickListener submitOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Database db = new Database(MainActivity.this,null,null,1);
            DataModel model = new DataModel(
                    0,
                    fname.getText().toString(),
                    lname.getText().toString(),email.getText().toString(),
                    gender,
                    phoneNumber.getText().toString());
            db.addDetails(model);
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            startActivity(intent);
        }
    };
}
