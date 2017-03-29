package com.example.ruwang.mydateselectordemo;

import android.databinding.ObservableField;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

/**
 * <b>Create Date:</b> 17/3/29<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> <br>
 */

public class MainModel {

    public ObservableField<String> date = new ObservableField<>("");
    private MyListener mListener;

    public MainModel(MyListener listener) {
        mListener = listener;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void btnClick(View view) {
//        DateSelect dateSelect = new DateSelect();
//        dateSelect.setListener(this,view);//一直调不到show方法中的fragmentactivity.getfragmentmanager方法
//        dateSelect.show();

        if (mListener != null) {
            mListener.showDialog();
        }
    }


    public interface MyListener {
        void showDialog();
    }
}
