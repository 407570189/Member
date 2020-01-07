package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class NicknameActivity extends AppCompatActivity {


    private EditText Nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);


    }
    public void right(View view){
        Nickname =findViewById(R.id.nickname);
        String NickName=Nickname.getText().toString();
        if(!TextUtils.isEmpty(NickName)) {
            SharedPreferences sp = getSharedPreferences("test", MODE_PRIVATE);
            sp.edit()
                    .putString("NAME", NickName)
                    .commit();
            Intent intent = new Intent(this, AgeActivity.class);
            startActivityForResult(intent, 0);
            setResult(RESULT_OK);
            finish();
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle("請輸入姓名")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
}
