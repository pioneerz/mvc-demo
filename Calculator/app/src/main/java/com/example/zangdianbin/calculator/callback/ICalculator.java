package com.example.zangdianbin.calculator.callback;

/**
 * Created by zangdianbin on 2017\8\28 0028.
 */

public interface ICalculator {
    public void pushOperand(String operand);
    public double pushOprate(String operate);
    public void reset();
}
