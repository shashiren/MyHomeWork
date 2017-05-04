package com.jikexueyuan.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ObtainActivity extends AppCompatActivity {

    private TextView mTvSendContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obtain_activity);

        Intent i = getIntent();
        mTvSendContent = (TextView) findViewById(R.id.tv);
        mTvSendContent.setText(i.getStringExtra("data"));
    }
}
    