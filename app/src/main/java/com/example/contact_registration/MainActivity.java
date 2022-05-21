package com.example.contact_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button action;
    EditText name, email, phone, pro;
    DB_Manager myob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        pro = (EditText) findViewById(R.id.profession);
        action = (Button) findViewById(R.id.add);
        myob = new DB_Manager(MainActivity.this);


       action.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String val1=name.getText().toString();
               String val2=email.getText().toString();
               String val3=phone.getText().toString();
               String val4=pro.getText().toString();
               boolean b=myob.insertdata(val1,val2,val3,val4);
               if(b==false){
                   Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(MainActivity.this, "Succesfully ", Toast.LENGTH_SHORT).show();
                  name.setText(null);
                   email.setText(null);
                   phone.setText(null);
                   pro.setText(null);
               }

           }
       });
    }
}