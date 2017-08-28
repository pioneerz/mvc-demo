package com.example.zangdianbin.calculator.view;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.example.zangdianbin.calculator.R;

/**
 * Created by zangdianbin on 2017\8\28 0028.
 */

public class CaOutputView {

    private TextView mTextView;

    public CaOutputView(Activity ac) {
        mTextView = ac.findViewById(R.id.result_output);
    }

    public void outputData(String str) {
        mTextView.setText(str);
    }

}
