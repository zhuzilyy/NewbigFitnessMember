package com.member.gufei.bigfitness.com.GuFei.Push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class HandlePushReceiver extends BroadcastReceiver {
    public HandlePushReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");
        Intent intent_dialog = new Intent(context,PushDetailActivity.class);
        intent_dialog.putExtra("title",title);
        intent_dialog.putExtra("message",message);
        context.startActivity(intent_dialog);
    }
}
