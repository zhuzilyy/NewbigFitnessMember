package com.member.gufei.bigfitness.com.GuFei.Push;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class HandlePushReceiver extends BroadcastReceiver {
    private String title;
    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");
        AlertDialog.Builder dialog=new AlertDialog.Builder(context);
        dialog.setTitle(title);//设置标题
        dialog.setMessage(message);//设置信息具体内容
        dialog.setCancelable(false);//设置是否可取消
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
