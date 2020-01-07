package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    private EditText Age2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    public void right(View view){
        Age2 =findViewById(R.id.age2);
        String age=Age2.getText().toString();
        if(!TextUtils.isEmpty(age)) {
            SharedPreferences sp = getSharedPreferences("test", MODE_PRIVATE);
            sp.edit()
                    .putString("AGE", age)
                    .commit();
            Intent intent = new Intent(this, GenderActivity.class);
            startActivityForResult(intent, 0);
            setResult(RESULT_OK);
            finish();
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle("請輸入年齡")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
}
