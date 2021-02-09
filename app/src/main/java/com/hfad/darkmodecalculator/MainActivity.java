package com.hfad.darkmodecalculator;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {
    TextView tvOutput;
    EditText etInput;


    Button btnClear, btnBracketLeft, btnBracketRight, btnDivide, btnMultiply, btnMinus, btnPlus, btnDot, btnBackspace, btnTotal;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    String calculation="0";


    public void updateText(String strToAdd) {
        String oldStr = etInput.getText().toString();
        int cursorPos = etInput.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        etInput.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        etInput.setSelection(cursorPos + 1);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvOutput = findViewById(R.id.tvOutput);
        etInput = findViewById(R.id.etInput);
        btnClear = findViewById(R.id.btnClear);
        btnBracketLeft = findViewById(R.id.btnBracketLeft);
        btnBracketRight = findViewById(R.id.btnBracketRight);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDot = findViewById(R.id.btnDot);
        btnBackspace = findViewById(R.id.btnBackspace);
        btnTotal = findViewById(R.id.btnTotal);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);

        etInput.setShowSoftInputOnFocus(false);
        etInput.setText("");
        tvOutput.setText("");


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText("");
                tvOutput.setText("");
            }
        });

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPosition = etInput.getSelectionStart();
                int Length = etInput.getText().length();
                if (cursorPosition != 0 && Length != 0) {
                    SpannableStringBuilder selection = (SpannableStringBuilder) etInput.getText();
                    selection.replace(cursorPosition - 1, cursorPosition, "");
                    etInput.setText(selection);
                    etInput.setSelection(cursorPosition - 1);
                }
            }
        });

        btnBracketLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("(");
            }
        });

        btnBracketRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(")");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("÷");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("×");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("-");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("+");
            }
        });


        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(".");
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(
                        "0");
            }
        });

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double finalResult = null;
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

                calculation = etInput.getText().toString();
                calculation = calculation.replaceAll("×", "*");
                calculation = calculation.replaceAll("÷", "/");
                int leftBrackets = 0;
                int rightBrackets = 0;
                for (int i = 0; i < calculation.length(); i++) {
                    if (calculation.substring(i, i + 1).equals("(")) {
                        leftBrackets++;
                    }
                    if (calculation.substring(i, i + 1).equals(")")) {
                        rightBrackets++;
                    }
                }
                if (leftBrackets > rightBrackets) {
                    tvOutput.setText("Add  )");
                }
                if (leftBrackets < rightBrackets) {
                    tvOutput.setText("Add  (");
                }

                try {
                    finalResult = (Double) engine.eval(calculation);
                } catch (ScriptException e) {
                    //e.printStackTrace();
                   Toast toast= Toast.makeText(getApplicationContext(),"hvh",Toast.LENGTH_SHORT);
                   toast.show();
                }





                if (finalResult != null) {
                    //If the result is not double  then  it will display an integer.
                    if (finalResult % 1 == 0) {
                        Double newData = new Double(finalResult);
                        int value = newData.intValue();
                        tvOutput.setText(String.valueOf(value));
                    }
                    if (finalResult % 1 != 0) {
                        tvOutput.setText(String.valueOf(finalResult));
                    }

                }

            }
        });

    }

}