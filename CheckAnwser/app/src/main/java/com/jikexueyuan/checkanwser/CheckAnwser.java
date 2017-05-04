package com.jikexueyuan.checkanwser;

import android.icu.util.IslamicCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;


public class CheckAnwser extends AppCompatActivity {
    private Button btnSubmit;
    private RadioButton rbMan;
    private RadioButton rbWomen;
    private CheckBox cbPacific,cbAtlantic,cbIndian,cbArctic,cbBohai,cbRuanyy;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkanwser);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rbMan = (RadioButton) findViewById(R.id.rbA);
        rbWomen = (RadioButton) findViewById(R.id.rbB);

        tvResult = (TextView) findViewById(R.id.tvResult);

        cbPacific = (CheckBox) findViewById(R.id.checkbox1);
        cbAtlantic = (CheckBox) findViewById(R.id.checkbox2);
        cbRuanyy = (CheckBox) findViewById(R.id.checkbox3);
        cbIndian = (CheckBox) findViewById(R.id.checkbox4);
        cbArctic = (CheckBox) findViewById(R.id.checkbox5);
        cbBohai = (CheckBox) findViewById(R.id.checkbox6);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = getString(R.string.str);
                String str1 = getString(R.string.str1);
                String str2 = getString(R.string.str2);
                String str3 = getString(R.string.str3);

                if(rbMan.isChecked()){
                    str+=rbMan.getText();
                    tvResult.setText(str);
                }else if (rbWomen.isChecked()){
                    str+=rbWomen.getText();
                    tvResult.setText(str);
                }else {
                    str+=str3;
                    tvResult.setText(str);
                }
                if (cbRuanyy.isChecked()&&cbBohai.isChecked()&&!cbPacific.isChecked()&&!cbAtlantic.isChecked()&&!cbIndian.isChecked()&&!cbArctic.isChecked()){
                    str+=","+str1;
                    tvResult.setText(str);
                }else {
                    str+=","+str2;
                    tvResult.setText(str);
                }

            }
        });
    }

}
