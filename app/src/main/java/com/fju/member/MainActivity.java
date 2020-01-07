package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int RT = 10;
    private TextView name;
    private TextView age;
    private TextView gender;
    public boolean logon=false;
    private String Name;
    private String Age;
    private String Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp=getSharedPreferences("test",MODE_PRIVATE);
        name = findViewById(R.id.name1);
        age = findViewById(R.id.age1);
        gender = findViewById(R.id.gender1);
        Name = name.getText().toString();
        Age = age.getText().toString();
        Gender = gender.getText().toString();
        if(!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Age) && !TextUtils.isEmpty(Gender)) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("成功訊息")
                    .setMessage("成功申請帳號")
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            Intent intent = new Intent(MainActivity.this,NicknameActivity.class);
            startActivityForResult(intent,RT);
        }

    }
}
