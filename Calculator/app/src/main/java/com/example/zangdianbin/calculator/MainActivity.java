package com.example.zangdianbin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zangdianbin.calculator.callback.ICalculator;
import com.example.zangdianbin.calculator.callback.IInputCallback;
import com.example.zangdianbin.calculator.model.CalModel;
import com.example.zangdianbin.calculator.view.CaInputView;
import com.example.zangdianbin.calculator.view.CaOutputView;

public class MainActivity extends AppCompatActivity implements IInputCallback{

    private CaInputView mCiv;
    private CaOutputView mCov;
    private ICalculator mModel;

    private String mNumber = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCiv = new CaInputView(this,this);
        mCov = new CaOutputView(this);
        mModel = new CalModel();
    }

    @Override
    public void operandIn(String operand) {
        mNumber = mNumber.equals("0")?operand:mNumber+operand;
        mCov.outputData(mNumber);
    }

    @Override
    public void operateIn(String operate) {
        if (operate.equalsIgnoreCase("C")) {
            mModel.reset();
            mNumber = "0";
            mCov.outputData(mNumber);
            return;
        }
        mModel.pushOperand(mNumber);
        double result = mModel.pushOprate(operate);
        if (result % 1d == 0d) {
            int tmp = Double.valueOf(result).intValue();
            mCov.outputData(String.valueOf(tmp));
        } else {
            mCov.outputData(String.valueOf(result));
        }

        mNumber = "0";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCiv.onDestory();
    }
}
