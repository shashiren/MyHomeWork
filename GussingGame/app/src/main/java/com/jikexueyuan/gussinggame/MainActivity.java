package com.jikexueyuan.gussinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.content.DialogInterface;
import android.app.AlertDialog;


public class MainActivity extends AppCompatActivity {
    private EditText et_number;
//    记录待猜的数字
    private int guessNumber;
//    记录用户输入的数字

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_number = (EditText) findViewById(R.id.editText);



        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number;
                String numstr = et_number.getText().toString();
//                输入框中没有数字;
                if (TextUtils.isEmpty(numstr)) {
                    guessNumber = (int) (Math.random() * 100 + 1);
                    String str = getString(R.string.tips1);
                    createDialog(str);
                    return;
                }
                number = Integer.parseInt(numstr);
                if (number > guessNumber) {
                    String str = getString(R.string.tips2) + number + getString(R.string.tips3);
                    createDialog(str);
                } else if (number < guessNumber) {
                    String str = getString(R.string.tips2) + number + getString(R.string.tips4);
                    createDialog(str);
                } else {
                    String str = getString(R.string.tips5);
                    createDialog(str);

                    //产生一个新的数字
//                    guessNumber = (int)(Math.random() * 100 + 1);
                }
                return;
            }


        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessNumber = (int) (Math.random() * 100 + 1);
            }
        });
    }


    public void createDialog(String str) {
        AlertDialog dlg = new AlertDialog.Builder(MainActivity.this).create();
        dlg.setTitle("");
        dlg.setMessage(str);

        //为退出按钮添加事件监听
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {

            //退出按钮响应函数
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
                et_number.setText("");
            }
        };

        dlg.setButton("确定", lis);
        dlg.show();
    }
}
