package com.example.ruwang.mydateselectordemo;

import android.view.View;

/**
 * <b>Create Date:</b> 17/3/29<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> <br>
 */

public class dateSelectModel {
    private DismissListener mDismissListener;


    public dateSelectModel(DismissListener dismissListener) {
        this.mDismissListener = dismissListener;
    }

    public void cancle(View view) {
        if (mDismissListener != null) {
            mDismissListener.onDismiss();
        }
    }

    public void sure(View view) {
        if (mDismissListener != null) {
            mDismissListener.onSure();
        }
    }


    /**
     * 接口回调监听 弹窗的操作
     */
    public interface DismissListener {
        void onDismiss();

        void onSure();
    }
}
