package com.example.zangdianbin.calculator.model;

import com.example.zangdianbin.calculator.callback.ICalculator;

import java.util.Stack;

/**
 * Created by zangdianbin on 2017\8\28 0028.
 */

public class CalModel implements ICalculator {

    private Stack<String> mDataStack = new Stack<>();
    private boolean isOperate = false;

    public static double popOpOffStack(Stack<String> stack) {
        double result = 0;
        double operand = Double.valueOf(stack.pop());
        if (stack.isEmpty()) {
            return operand;
        }
        String operate = stack.pop();
        if (operate.equals("+")) {
            result = popOpOffStack(stack)+operand;
        } else if (operate.equals("-")) {
            result = popOpOffStack(stack)-operand;
        } else if (operate.equals("*")) {
            result = popOpOffStack(stack)*operand;
        } else if (operate.equals("/")) {
            result = popOpOffStack(stack)/operand;
        }
        return result;
    }

    @Override
    public void pushOperand(String operand) {
        mDataStack.add(operand);
        isOperate = false;
    }

    @Override
    public double pushOprate(String operate) {
        double result = 0;
        if (isOperate) {
            mDataStack.pop();
        }
        if (operate.equals("=")) {
            result = popOpOffStack(mDataStack);
        } else {
            Stack<String> tmpStack = (Stack<String>) mDataStack.clone();
            result = popOpOffStack(tmpStack);
            mDataStack.add(operate);
            isOperate = true;
        }
        return result;
    }

    @Override
    public void reset() {
        mDataStack.removeAllElements();
        isOperate = false;
    }
}
