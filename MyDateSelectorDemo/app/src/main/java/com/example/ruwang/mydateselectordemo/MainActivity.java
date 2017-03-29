package com.example.ruwang.mydateselectordemo;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;

import com.example.ruwang.mydateselectordemo.MainModel.MyListener;
import com.example.ruwang.mydateselectordemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MyListener, DatePickerDialog.OnDateSetListener {

    private ActivityMainBinding mBinding;
    private MainModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mModel = new MainModel(this);
        mBinding.setModel(mModel);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showDialog() {
        DateSelect dateSelect = new DateSelect();
        dateSelect.setListener(this, this);
        dateSelect.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mModel.date.set(String.valueOf(year) + "年" + String.valueOf(month + 1) + "月" + String.valueOf(dayOfMonth) + "日");
    }
}
