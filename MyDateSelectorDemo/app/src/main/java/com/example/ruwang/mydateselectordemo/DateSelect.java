package com.example.ruwang.mydateselectordemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatDialog;
import android.view.LayoutInflater;
import android.widget.DatePicker;

import com.example.ruwang.mydateselectordemo.databinding.DateSelectBinding;

/**
 * <b>Create Date:</b> 17/3/29<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> <br>
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class DateSelect extends DialogFragment implements DatePicker.OnDateChangedListener, dateSelectModel.DismissListener {

    public AppCompatDialog dialog;
    private DateSelectBinding mBinding;
    private Calendar mCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener mListener;
    private DatePicker pick;
    private FragmentActivity f;

    public DateSelect() {
    }

    //也可以将监听器填入构造函数中
    public void setListener(DatePickerDialog.OnDateSetListener listener, FragmentActivity fra) {
        mListener = listener;
        this.f = fra;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new AppCompatDialog(getContext());
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.date_select, null, false);
        mBinding.setModel(new dateSelectModel(this));
        pick = mBinding.datePick;
        pick.init(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH), this);
        dialog.setContentView(mBinding.getRoot());
        return dialog;
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }

    @Override
    public void onDismiss() {
        dialog.dismiss();
    }

    @Override
    public void onSure() {
        if (mListener != null) {
            //设置日期选择器的原始值
            mListener.onDateSet(pick, pick.getYear(), pick.getMonth(), pick.getDayOfMonth());
            dialog.dismiss();
        }
    }

    public void show() {
        show(f.getFragmentManager());
    }


    public void show(FragmentManager f) {
        super.show(f, "");
    }

}
