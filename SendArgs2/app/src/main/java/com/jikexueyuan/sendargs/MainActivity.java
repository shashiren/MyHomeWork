package com.jikexueyuan.sendargs;

import android.content.Intent;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView = (TextView) findViewById(R.id.textView);


        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TheAty.class);
//                i.putExtra("data","Hello jikexueyuan");
//                Bundle b = new Bundle();
//                b.putString("name","jikexueyuan");
//                b.putInt("age",2);
//                b.putString("name1","zhou");
//                i.putExtras(b);
//                i.putExtra("data",b);
                i.putExtra("user",new User("jikexueyuan",2));
//                startActivity(i);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView.setText("另一个Activity返回的数据是:"+data.getStringExtra("data"));
    }
}
