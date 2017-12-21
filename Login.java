package com.example.alex.askii;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login extends AppCompatActivity {
    Button login;
    EditText userNameET;
    EditText passWordET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button)findViewById(R.id.Login);
        userNameET = (EditText)findViewById(R.id.username);
        passWordET = (EditText)findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                //get text valiues
                String userName = userNameET.getText().toString();
                String passWord = passWordET.getText().toString();
                //Query in java the username
                Select user = new Select();
                String actualUser = user.getUserName(userName);
                String actualPassword = user.getPassword(passWord);
                //If Correct
                if(userName.equals(actualUser)&& passWord.equals(actualPassword)){
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    //Then go to next page
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }

            }

        }); //Remember ); for on clickListener()

    }

}
