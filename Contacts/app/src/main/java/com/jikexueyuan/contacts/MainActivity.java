package com.jikexueyuan.contacts;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class    MainActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtNumber;
    private MyAdapter adapter;
    private ListView lv;
    private String contactname;
    private String contactnumber;
    private List<People> contacts = new ArrayList<People>() ;
    private Button btn_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<People>();
        adapter = new MyAdapter(this,contacts);
        lv = (ListView) findViewById(R.id.lv1);
        lv.setAdapter(adapter);
//        adapter.addContact(new People());
//        adapter.addContact(new People());
//        setcontactsPeopleData();
        btn_add = (Button) findViewById(R.id.btn1);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPermisson();
                showAddDialog();
                setcontactsPeopleData();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int arg0, long l) {
               People contact = adapter.getItem(arg0);
//                showUpdateDialog(contact);
                setcontactsPeopleData();
                showCallDialog();

            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int arg0, long l) {
                People contact = adapter.getItem(arg0);
                ContactManager.deleteContact(MainActivity.this,contact);
                setcontactsPeopleData();
                return true;
            }
        });
         setcontactsPeopleData();
    }
    private void setcontactsPeopleData() {
        List<People> contactData = ContactManager.getNumber(this);
        contacts.clear();
        contactData.addAll(contactData);
        adapter.notifyDataSetChanged();

    }

    private void showAddDialog(){
        View inputMessage = View.inflate(this, R.layout.inputmessage,null);
        edtName = (EditText) inputMessage.findViewById(R.id.edt1);
        edtNumber = (EditText) inputMessage.findViewById(R.id.edt2);
        contactname = edtName.getText()+"";
        contactnumber = edtNumber.getText()+"";
        new AlertDialog.Builder(this)
                .setTitle("添加联系人")
                .setView(inputMessage)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        People contact = new People("","");
                        contact.setName(contactname);
                        contact.setNumber(contactnumber);

//                        contact.setName(edtName.getText()+"");
//                        contact.setNumber(edtNumber.getText()+"");
                        ContactManager.addContact(MainActivity.this,contact);
                        setcontactsPeopleData();
                    }
                })
                .setNegativeButton("取消",null)
                .show();
    }
    private void showUpdateDialog(final People oldContact){
        View inputMessage = View.inflate(this, R.layout.inputmessage,null);
        edtName = (EditText) inputMessage.findViewById(R.id.edt1);
        edtNumber = (EditText) inputMessage.findViewById(R.id.edt2);
        edtName.setText(oldContact.getName());
        edtNumber.setText(oldContact.getNumber());

        new AlertDialog.Builder(this)
                .setTitle("修改联系人")
                .setView(inputMessage)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        People contact = new People(null,null);
                        contact.setRawContactId(oldContact.getRawContactId());
                        contact.setRawContactId(oldContact);
                        contact.setName(edtName.getText().toString().trim());
                        contact.setNumber(edtNumber.getText().toString().trim());
                        ContactManager.updateContact(MainActivity.this,contact);
                        setcontactsPeopleData();
                    }
                })
                .setNegativeButton("取消",null)
                .show();
    }


    private void showCallDialog(){
        View call = View.inflate(this, R.layout.call_sendmessage,null);
        Button btn1 = (Button) call.findViewById(R.id.call);
        Button btn2 = (Button) call.findViewById(R.id.send);

        new AlertDialog.Builder(this)
                .setTitle("请选择")
                .setView(call)
                .setNegativeButton("取消",null)
                .show();
        btn1.findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneCall();
            }
        });
        btn2.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void phoneCall(){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:"+edtNumber));
        MainActivity.this.startActivity(intent);
    }

    private void sendMessage(){
          Intent intent =new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setData(Uri.parse("message:"+edtNumber));
        MainActivity.this.startActivity(intent);
    }


    public void setting() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }
    private void getPermisson(){

                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                    } else {

                        new AlertDialog.Builder(this)
                                .setTitle("注意")
                                .setMessage("请设置权限")
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        setting();
                                    }
                                })
                                .show();

                    }

                }else {

                }

    }
}