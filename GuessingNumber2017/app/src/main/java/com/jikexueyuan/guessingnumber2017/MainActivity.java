package com.jikexueyuan.guessingnumber2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private EditText et_number;
    //    记录待猜的数字
    private int guessNumber;
    //    记录用户输入的数字
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = (EditText)findViewById(R.id.editText3);

//        guessNumber = (int)(Math.random() * 100 + 1);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number;
                String numstr = et_number.getText().toString();
//                输入框中没有数字;
                if (numstr.isEmpty()){
                    guessNumber = (int)(Math.random() * 100 + 1);
                    String str ="请在输入框中输入一个你猜的数字";
                    createDialog(str);
                    return;
                }
                number = Integer.parseInt(numstr);
                if(number > guessNumber) {
                    String str = "你猜的数字" + number + "大了,点击确定按钮重新猜";
                    createDialog(str);
                } else if(number < guessNumber){
                    String str = "你猜的数字" + number + "小了,点击确定按钮重新猜";
                    createDialog(str);
                } else {
                    String str = "恭喜你猜对了";
                    createDialog(str);

                    //产生一个新的数字
//                    guessNumber = (int)(Math.random() * 100 + 1);
                }
                return;
            }
            public void createDialog(String str){
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

        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessNumber = (int)(Math.random() * 100 + 1);
            }
        });
    }
}
