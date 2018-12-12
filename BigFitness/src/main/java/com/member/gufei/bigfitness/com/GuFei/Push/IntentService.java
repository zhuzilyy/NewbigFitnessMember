package com.member.gufei.bigfitness.com.GuFei.Push;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.main.MainActivity;
import com.member.gufei.bigfitness.util.SpUtil;

/**
 * Created by Administrator on 2017/8/4.
 * 个推工具类
 */

public  class IntentService  extends GTIntentService {
    private NotificationManager myManager = null;
    private Notification myNotification;
    private static final int NOTIFICATION_ID_1 = 1;
    public IntentService() {

    }
    @Override
    public void onReceiveServicePid(
            Context context, int pid) {
    }
/**
 *  第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
 */

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();
        Log.i("tag", "onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload == null) {
            Log.e(TAG, "receiver payload = null");
        } else {
            String data = new String(payload);
            Log.d(TAG, "receiver payload = " + data);

        }

        Log.d(TAG, "----------------------------------------------------------------------------------------------");



        //1.从系统服务中获得通知管理器
        myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Log.e(TAG, "onReceiveClientId -> " + "GTTransmitMessage = " +new String(msg.getPayload()));

        Toast.makeText(context,new String(msg.getPayload()),Toast.LENGTH_SHORT).show();

        String msgStr=new String(msg.getPayload());

        String taskStr=new String(msg.getTaskId());
        String Name=new String(msg.getPkgName());

        //3.定义一个PendingIntent，点击Notification后启动一个Activity
        PendingIntent pi = PendingIntent.getActivity(
                context,
                100,
                new Intent(context, MainActivity.class),
                PendingIntent.FLAG_CANCEL_CURRENT
        );

        //2.通过Notification.Builder来创建通知
        Notification.Builder myBuilder = new Notification.Builder(context);
        myBuilder.setContentTitle(context.getString(R.string.app_name))
                .setContentText("系统通知")
                .setSubText(msgStr)
                .setTicker("您收到新的消息")
                //设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示
                .setSmallIcon(R.mipmap.ui)
//                .setLargeIcon(R.mipmap.ui)
                //设置默认声音和震动
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)//点击后取消
                .setWhen(System.currentTimeMillis())//设置通知时间
                .setPriority(Notification.PRIORITY_HIGH)//高优先级
//                .setVisibility(Notification.VISIBILITY_PUBLIC)
                //android5.0加入了一种新的模式Notification的显示等级，共有三种：
                //VISIBILITY_PUBLIC  只有在没有锁屏时会显示通知
                //VISIBILITY_PRIVATE 任何情况都会显示通知
                //VISIBILITY_SECRET  在安全锁和没有锁屏的情况下显示通知
                .setContentIntent(pi);  //3.关联PendingIntent
        myNotification = myBuilder.build();
        //4.通过通知管理器来发起通知，ID区分通知
        myManager.notify(NOTIFICATION_ID_1, myNotification);

    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
        //Toast.makeText(context, clientid, Toast.LENGTH_LONG).show();
        Log.i("tag", "onReceiveClientId -> " + "clientid = " + clientid);
        SpUtil.put(this,"clientId",clientid);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }

    @Override
    public void onNotificationMessageArrived(final Context context, GTNotificationMessage gtNotificationMessage) {
        //接受到推送的通知发送广播给baseActivity显示对话框
        Intent intent = new Intent();
        intent.putExtra("title",gtNotificationMessage.getTitle());
        intent.putExtra("messageId",gtNotificationMessage.getMessageId());
        intent.putExtra("message",gtNotificationMessage.getContent());
        intent.setAction("com.action.receive.message");
        sendBroadcast(intent);
    }
    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage gtNotificationMessage) {

    }
}
