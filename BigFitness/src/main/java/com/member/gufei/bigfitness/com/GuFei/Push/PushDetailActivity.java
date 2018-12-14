package com.member.gufei.bigfitness.com.GuFei.Push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;

public class PushDetailActivity extends Activity {
    private TextView tv_title,tv_message,tv_confirm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_detail);
        initViews();
    }

    private void initViews() {
        tv_title = findViewById(R.id.tv_title);
        tv_message = findViewById(R.id.tv_message);
        tv_confirm = findViewById(R.id.tv_confirm);
        Intent intent = getIntent();
        if(intent!=null){
            String title = intent.getStringExtra("title");
            String message = intent.getStringExtra("message");
            tv_title.setText(title);
            tv_message.setText(message);
        }
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
