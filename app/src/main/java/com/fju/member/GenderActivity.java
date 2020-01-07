package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    private EditText gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void back(View view) {
        gender = findViewById(R.id.gender2);
        String Gender = gender.getText().toString();
        if (!TextUtils.isEmpty(Gender)) {
            SharedPreferences sp = getSharedPreferences("test", MODE_PRIVATE);
            sp.edit()
                    .putString("GENDER", Gender)
                    .commit();

           finish();
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle("請輸入性別")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
}
