package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etTK,etMK;
    private Button btDN;
    private CheckBox ckLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMK=(EditText)findViewById(R.id.et_mk);
        etTK=(EditText)findViewById(R.id.et_tk);
        btDN = (Button) findViewById(R.id.bt_dn);
        ckLuu = (CheckBox) findViewById(R.id.ck_luu);
        btDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk,mk;
                tk = etTK.getText().toString();
                mk=etMK.getText().toString();
                if(!tk.isEmpty()&& !mk.isEmpty()){
                    if(ckLuu.isChecked()){
                        Toast.makeText(MainActivity.this,"Thông tin của bạn đã được lưu",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Thông tin của bạn chưa được lưu",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                if(!tk.isEmpty()&&!mk.isEmpty()){
                    Intent intent = new Intent(MainActivity.this,ListForm.class);
                    startActivity(intent);
                }
            }
        });
    }
}
