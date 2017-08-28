package com.example.zangdianbin.calculator.view;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.zangdianbin.calculator.callback.IInputCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zangdianbin on 2017\8\28 0028.
 */

public class CaInputView {

    private IInputCallback mCallback;

    List<Button> mOperands = new ArrayList<>();
    List<Button> mOperates = new ArrayList<>();

    public CaInputView(Activity ac, IInputCallback call) {
        mCallback = call;

        Resources res = ac.getResources();
        for (int i=0; i <= 9; i++) {

            if (i<=5) {
                int id_operate = res.getIdentifier("operate"+i,"id",ac.getPackageName());
                Button btn_operate = ac.findViewById(id_operate);
                mOperates.add(btn_operate);
            }

            int id_operand = res.getIdentifier("operand"+i,"id",ac.getPackageName());
            Button btn_operand = ac.findViewById(id_operand);
            mOperands.add(btn_operand);
        }

        for (Button btn:mOperands) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = getButtonText(view);
                    if (!TextUtils.isEmpty(text) && mCallback != null) {
                        mCallback.operandIn(text);
                    }
                }
            });
        }
        for (Button btn:mOperates) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = getButtonText(view);
                    if (!TextUtils.isEmpty(text) && mCallback != null) {
                        mCallback.operateIn(text);
                    }
                }
            });

        }

    }

    private String getButtonText(View v) {
        Button cli_btn = (Button) v;
        return cli_btn.getText().toString();
    }

    public void onDestory() {
        if (mCallback != null) {
            mCallback = null;
        }
    }

}
