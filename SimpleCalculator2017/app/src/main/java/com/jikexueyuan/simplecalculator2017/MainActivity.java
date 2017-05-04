package com.jikexueyuan.simplecalculator2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private List<Item> items = new ArrayList<Item>();
    private EditText etInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_c).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);


        etInput = (EditText) findViewById(R.id.et_input);  //实例化之后的显示屏


    }


    @Override
    public void onClick(View view) {
        String str = etInput.getText().toString();

        switch (view.getId()) {
            case R.id.btn_0:
                checkAndClear();
                etInput.append("0");
                break;
            case R.id.btn_1:

                checkAndClear();
                etInput.append("1");
                break;
            case R.id.btn_2:
                checkAndClear();
                etInput.append("2");
                break;
            case R.id.btn_3:
                checkAndClear();
                etInput.append("3");
                break;
            case R.id.btn_4:
                checkAndClear();
                etInput.append("4");
                break;
            case R.id.btn_5:
                checkAndClear();
                etInput.append("5");
                break;
            case R.id.btn_6:
                checkAndClear();
                etInput.append("6");
                break;
            case R.id.btn_7:
                checkAndClear();
                etInput.append("7");
                break;
            case R.id.btn_8:
                checkAndClear();
                etInput.append("8");
                break;
            case R.id.btn_9:
                checkAndClear();
                etInput.append("9");
                break;
            case R.id.btn_plus:
                items.add(new Item(Double.parseDouble(etInput.getText().toString()),Types.num));
                checkAndCompute();
                items.add(new Item(0,Types.plus));
                etInput.setText("");
                break;


            case R.id.btn_minus:
                items.add(new Item(Double.parseDouble(etInput.getText().toString()),Types.num));
                checkAndCompute();
                items.add(new Item(0,Types.minus));
                etInput.setText("");
                break;

            case R.id.btn_multiply:

                items.add(new Item(Double.parseDouble(etInput.getText().toString()),Types.num));
                checkAndCompute();
                items.add(new Item(0,Types.multiply));
                etInput.setText("");
                break;
            case R.id.btn_divide:

                items.add(new Item(Double.parseDouble(etInput.getText().toString()),Types.num));
                checkAndCompute();
                etInput.setText("");
                items.add(new Item(0,Types.divide));
                etInput.setText("");

                break;

            case R.id.btn_c:

                etInput.setText("");
                items.clear();
                break;
            case R.id.btn_equal:
                items.add(new Item(Double.parseDouble(etInput.getText().toString()),Types.num));
                checkAndCompute();
                etInput.setText(items.get(0).value+"");
                items.clear();

                break;


        }


    }
//    实现加减乘除运算

    public void checkAndCompute(){
        if (items.size()>=3) {

            double a = items.get(0).value;
            double b = items.get(2).value;
            int opt = items.get(1).type;
            items.clear();

            Toast tipsToast = Toast.makeText(MainActivity.this, R.string.tips,Toast.LENGTH_LONG);
            tipsToast.setGravity(Gravity.CENTER,0,0);


            switch (opt) {
                case Types.plus:
                    items.add(new Item(a + b, Types.num));

                    break;
                case Types.minus:
                    items.add(new Item(a - b, Types.num));

                    break;
                case Types.multiply:

                    items.add(new Item(a * b, Types.num));
                    break;
                case Types.divide:
                    if (b==0){
                        items.add(new Item(a,Types.num));
                        tipsToast.show();
//                        当被除数等于0时添加提示
                    }else {
                    items.add(new Item(a / b, Types.num));
                    }
                    break;
            }
        }
    }

    public void checkAndClear(){
        String str = etInput.getText().toString();
        if (!str.equals("")){
            etInput.setText("");
        }
    }


}
