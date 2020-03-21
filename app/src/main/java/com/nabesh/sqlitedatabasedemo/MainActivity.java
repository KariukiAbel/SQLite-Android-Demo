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
    private TextView tv;
    private EditText fname, lname, email, phoneNumber;
    private RadioButton male, female;
    private Button submit;
    private String gender,firstname, lastname, mail, phoneno;

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
        tv = findViewById(R.id.textView3);

        firstname = fname.getText().toString();
        lastname = lname.getText().toString();
        mail = email.getText().toString();
        phoneno = phoneNumber.getText().toString();

        if (male.isSelected()){
            gender = male.getText().toString();
        }else {
            gender = female.getText().toString();
        }

        if (firstname.isEmpty() || lastname.isEmpty() || mail.isEmpty() || phoneno.isEmpty()){
            tv.setText("Fill in all fields!");
            tv.setTextColor(getResources().getColor(R.color.invalid));
        }

        submit = findViewById(R.id.button);
        submit.setOnClickListener(submitOnClickListener);
    }

    private View.OnClickListener submitOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Database db = new Database(MainActivity.this,null,null,1);
            DataModel model = new DataModel(0, firstname, lastname, mail, gender, phoneno);
            db.addDetails(model);
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            startActivity(intent);
        }
    };
}
