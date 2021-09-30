package com.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText operations, display;
    private String operation, displayCurr, displayRes;
    private boolean dot_ins, operator_ins;
    private BigDecimal res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operations = findViewById(R.id.operations);
        display = findViewById(R.id.display);
        clear();

        Button button_zero = findViewById(R.id.button_zero);
        button_zero.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "0";
                displayCurrent();
            }
        });
        Button button_one = findViewById(R.id.button_one);
        button_one.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "1";
            }
            else {
                displayCurr = "1";
            }
            displayCurrent();
        });
        Button button_two = findViewById(R.id.button_two);
        button_two.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "2";
            }
            else {
                displayCurr = "2";
            }
            displayCurrent();
        });
        Button button_three = findViewById(R.id.button_three);
        button_three.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "3";
            }
            else {
                displayCurr = "3";
            }
            displayCurrent();
        });
        Button button_four = findViewById(R.id.button_four);
        button_four.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "4";
            }
            else {
                displayCurr = "4";
            }
            displayCurrent();
        });
        Button button_five = findViewById(R.id.button_five);
        button_five.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "5";
            }
            else {
                displayCurr = "5";
            }
            displayCurrent();
        });
        Button button_six = findViewById(R.id.button_six);
        button_six.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "6";
            }
            else {
                displayCurr = "6";
            }
            displayCurrent();
        });
        Button button_seven = findViewById(R.id.button_seven);
        button_seven.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "7";
            }
            else {
                displayCurr = "7";
            }
            displayCurrent();
        });
        Button button_eight = findViewById(R.id.button_eight);
        button_eight.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "8";
            }
            else {
                displayCurr = "8";
            }
            displayCurrent();
        });
        Button button_nine = findViewById(R.id.button_nine);
        button_nine.setOnClickListener(view -> {
            if(!displayCurr.equals("0")) {
                displayCurr = displayCurr + "9";
            }
            else {
                displayCurr = "9";
            }
            displayCurrent();
        });
        Button button_dot = findViewById(R.id.button_dot);
        button_dot.setOnClickListener(view -> {
            if(!dot_ins) {
                displayCurr = displayCurr + ".";
                dot_ins = true;
                displayCurrent();
            }
        });
        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(view -> {
            back();
            displayCurrent();
        });
        Button button_equals = findViewById(R.id.button_equals);
        button_equals.setOnClickListener(view -> equal());
        Button button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(view -> {
            dot_ins = false;
            if(!displayCurr.isEmpty()){
                if(displayCurr.endsWith(".")) {
                    back();
                    displayCurrent();
                }
                if (operator_ins) {
                    equal();
                }
                operation = displayCurr.substring(0, Math.min(displayCurr.length(), 10)) + " + ";
                displayCurr = "0";
                displayOperation();
                operator_ins = true;
            }
        });
        Button button_sub = findViewById(R.id.button_sub);
        button_sub.setOnClickListener(view -> {
            dot_ins = false;
            if(!displayCurr.isEmpty()){
                if(displayCurr.endsWith(".")) {
                    back();
                    displayCurrent();
                }
                if (operator_ins) {
                    equal();
                }
                operation = displayCurr.substring(0, Math.min(displayCurr.length(), 10)) + " - ";
                displayCurr = "0";
                displayOperation();
                operator_ins = true;
            }
            displayOperation();
        });
        Button button_multiply = findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(view -> {
            dot_ins = false;
            if(!displayCurr.isEmpty()){
                if(displayCurr.endsWith(".")) {
                    back();
                    displayCurrent();
                }
                if (operator_ins) {
                    equal();
                }
                operation = displayCurr.substring(0, Math.min(displayCurr.length(), 10)) + " × ";
                displayCurr = "0";
                displayOperation();
                operator_ins = true;
            }
            displayOperation();
        });
        Button button_divide = findViewById(R.id.button_divide);
        button_divide.setOnClickListener(view -> {
            dot_ins = false;
            if(!displayCurr.isEmpty()) {
                if (displayCurr.endsWith(".")) {
                    back();
                    displayCurrent();
                }
                if (operator_ins) {
                    equal();
                }
                operation = displayCurr.substring(0, Math.min(displayCurr.length(), 10)) + " ÷ ";
                displayCurr = "0";
                displayOperation();
                operator_ins = true;
            }
        });
        Button button_percent = findViewById(R.id.button_percent);
        button_percent.setOnClickListener(view -> {
            if (displayCurr != "0" || displayCurr != "0."){
                BigDecimal factor = BigDecimal.valueOf(0.01);
                BigDecimal percent = new BigDecimal(displayCurr);
                percent = percent.multiply(factor, MathContext.DECIMAL32).setScale(7, RoundingMode.HALF_EVEN).stripTrailingZeros();
                displayCurr = percent.toPlainString();
                displayCurrent();
            }
        });
        Button button_negative = findViewById(R.id.button_negative);
        button_negative.setOnClickListener(view -> {
            if (displayCurr.equals("-")){
                displayCurr = "0";
            }else {
                if (displayCurr.equals("0")) {
                    displayCurr = "-";
                } else {
                    if (displayCurr.charAt(0) == '-') {
                        displayCurr = displayCurr.substring(1);
                    } else {
                        displayCurr = "-" + displayCurr;
                    }
                }
            }
            displayCurrent();
        });
        Button button_clear = findViewById(R.id.button_clear);
        button_clear.setOnClickListener(view -> {
                clear();
                displayCurrent();
                displayOperation();
            });
    }
    public void displayCurrent(){
        display.setText(displayCurr);
    }
    public void displayOperation(){
        operations.setText(operation);
    }
    public void displayResult(){
        if (displayRes.length() <= 10) {
            display.setText(displayRes);
            displayCurr = displayRes;
        }else {
            display.setText("too much!");
            displayCurr = "0";
            displayRes = "0";
        }
        operator_ins = false;
    }
    public void clear(){
        displayCurr = "0";
        displayCurrent();
        displayRes = "";
        operation = "";
        displayOperation();
        res = BigDecimal.ZERO;
        dot_ins = false;
        operator_ins = false;
    }
    public void equal(){
            if(!displayCurr.isEmpty() && operator_ins && operation.endsWith(" ")){
                operation = operation + displayCurr;
                String [] token = operation.split(" ");
                BigDecimal right;
                BigDecimal left;
                if (res.compareTo(BigDecimal.ZERO) != 0 && res.equals(new BigDecimal(displayCurr))){
                    left = res;
                }else {
                    left = new BigDecimal(token[0]);
                }
                right = new BigDecimal(token[2]);

                switch (token[1].charAt(0)){
                    case '+':
                        BigDecimal Plus = left.add(right, MathContext.DECIMAL32).setScale(7, RoundingMode.HALF_EVEN).stripTrailingZeros();
                        res = Plus;
                        displayRes = Plus.toPlainString();
                        displayResult();
                        break;
                    case '-':
                        BigDecimal Minus = left.subtract(right, MathContext.DECIMAL32).setScale(7, RoundingMode.HALF_EVEN).stripTrailingZeros();
                        res = Minus;
                        displayRes = Minus.toPlainString();
                        displayResult();
                        break;
                    case '×':
                        BigDecimal Multiply = left.multiply(right, MathContext.DECIMAL32).setScale(7, RoundingMode.HALF_EVEN).stripTrailingZeros();
                        res = Multiply;
                        displayRes = Multiply.toPlainString();
                        displayResult();
                        break;
                    case '÷':
                        if (right.compareTo(BigDecimal.ZERO) != 0) {
                            BigDecimal Divide = left.divide(right, MathContext.DECIMAL32).setScale(7, RoundingMode.HALF_EVEN).stripTrailingZeros();
                            res = Divide;
                            displayRes = Divide.toPlainString();
                            displayResult();
                            break;
                        }

                }
                displayOperation();
            }
        }
    public void back(){
        if (!displayCurr.equals("0")) {
            if (displayCurr.equals("") || (displayCurr.length() == 1)) {
                displayCurr = "0";
            }
            else {
                if (displayCurr.endsWith(".")) {
                    dot_ins = false;
                }
                if (displayCurr.endsWith(" ")) {
                    displayCurr = displayCurr.substring(0, displayCurr.length() - 3);
                    operator_ins = false;
                }
                else {
                    displayCurr = displayCurr.substring(0, displayCurr.length() - 1);
                }
            }
        }
    }
}