package com.member.gufei.bigfitness.com.GuFei.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.com.GuFei.Dialog.number.NumberProgressBar;
import com.member.gufei.bigfitness.util.ModelUtil;


/**
 * Created by Jue on 2016/4/29.
 */
public class UpdateDialog {

    private Context context;
    private LayoutInflater inflater;
    final Dialog dialog;
    private OnUpdateListener onUpdateListener;
    private NumberProgressBar number_progress_bar;
    private View btn_tv;
    private OnCancelListener onCancelListener;

    public UpdateDialog(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        dialog = new Dialog(context, R.style.transparentFrameWindowStyle);
    }

    public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.onUpdateListener = onUpdateListener;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    public void setData(String tip) {
        View view = inflater.inflate(R.layout.dialog_update, null);
        Button close_btn = view.findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        number_progress_bar = view.findViewById(R.id.number_progress_bar);
        ImageView update_header = view.findViewById(R.id.update_header);

        btn_tv = view.findViewById(R.id.btn_tv);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onUpdateListener != null)
                    onUpdateListener.onUpdate();
            }
        });

        TextView update_tv = view.findViewById(R.id.update_tv);
        update_tv.setText(tip);


        dialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

    /*    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        //This makes the dialog take up the full width
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        window.setAttributes(lp);*/
        ConstraintLayout.LayoutParams headerParams = (ConstraintLayout.LayoutParams) update_header.getLayoutParams();
        headerParams.height = (int) ((ModelUtil.getScreenWidth(context) - ModelUtil.dip2px(context, 60)) * 0.7);
        update_header.setLayoutParams(headerParams);

        // 设置显示动画
        Window window = dialog.getWindow();
        // window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.y = -ModelUtil.dip2px(context, 30);
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ModelUtil.getScreenWidth(context) - ModelUtil.dip2px(context, 60);
        // wl.height = (int) (wl.width * 1.49) + ModelUtil.dip2px(context, 30);
        // 设置显示位置
        dialog.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(false);

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (onCancelListener != null)
                    onCancelListener.onCancel();
            }
        });
    }

    public void dismiss() {
        dialog.dismiss();
    }

    public void show() {
        dialog.show();
    }

    public void setProgress(int l) {
        btn_tv.setVisibility(View.INVISIBLE);
        number_progress_bar.setVisibility(View.VISIBLE);
        number_progress_bar.setProgress(l);
    }

    public interface OnUpdateListener {
        void onUpdate();
    }

    public interface OnCancelListener {
        void onCancel();
    }
}
