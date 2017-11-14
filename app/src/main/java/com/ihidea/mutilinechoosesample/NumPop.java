package com.ihidea.mutilinechoosesample;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class NumPop implements CanShow {

    TextView mTitleAlertTv;

    EditText mContentTv;

    TextView mLeftBtn;

    TextView mRightBtn;

    private Context mContext;

    private PopupWindow popwindow;

    private View popview;

    public NumPop(final Context context, final XCallbackListener leftListener,
            final XCallbackListener rightBtnClickListener) {

        super();

        this.mContext = context;

        LayoutInflater flater = LayoutInflater.from(this.mContext);
        popview = flater.inflate(com.ihidea.multilinechooselib.R.layout.pop_num, null);

        mTitleAlertTv = (TextView) popview.findViewById(com.ihidea.multilinechooselib.R.id.title_alert_tv);
        mContentTv = (EditText) popview.findViewById(com.ihidea.multilinechooselib.R.id.content_log_tv);
        mLeftBtn = (TextView) popview.findViewById(com.ihidea.multilinechooselib.R.id.leftBtn);
        mRightBtn = (TextView) popview.findViewById(com.ihidea.multilinechooselib.R.id.rightBtn);
        
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftListener != null) {
                    leftListener.call();
                }
                hide();
            }
        });
        
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mContentTv.getText().toString())) {
                    if (rightBtnClickListener != null) {
                        rightBtnClickListener.call(mContentTv.getText().toString());
                    }
                    
                    hide();
                }
                else {
                    Toast.makeText(mContext, "请输入数量", Toast.LENGTH_LONG).show();
                    return;
                }
                
            }
        });
        
        popwindow = new PopupWindow(popview, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        popwindow.setBackgroundDrawable(new BitmapDrawable(context.getResources()));
        popwindow.setTouchable(true);
        popwindow.setOutsideTouchable(true);
        popwindow.setFocusable(true);
        popwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroundAlpha(1.0f);
            }
        });
        
    }
    
    @Override
    public void hide() {
        popwindow.dismiss();
    }
    
    @Override
    public boolean isShow() {
        
        return popwindow.isShowing();
    }
    
    @Override
    public synchronized void show() {
        if (!isShow()) {
            setBackgroundAlpha(0.5f);
            popwindow.showAtLocation(popview, Gravity.CENTER, 0, 0);
            
        }
    }
    
    private void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) mContext).getWindow().setAttributes(lp);
    }
}
