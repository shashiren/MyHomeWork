package com.jikexueyuan.sendargs;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class SendActivity extends AppCompatActivity {
    EditText mETContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_activity);

        mETContent = (EditText) findViewById(R.id.et_content);



        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SendActivity.this,ObtainActivity.class);
                if("".equals(mETContent.getText().toString())) {
                    String str = "你输入的内容为空,请输入你要传递的数据";
                    createDialog(str);
                }else {
                    i.putExtra("data",mETContent.getText().toString());

                    startActivity(i);
                }
            }
        });
    }
    public void createDialog(String str){
        AlertDialog dlg = new AlertDialog.Builder(SendActivity.this).create();
        dlg.setTitle("提示");
        dlg.setMessage(str);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {

            //退出按钮响应函数
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
                mETContent.setText("");
            }
        };

        dlg.setButton("确定", lis);

                dlg.show();

    }
}
