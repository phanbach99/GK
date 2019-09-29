package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et_filename = (EditText)findViewById(R.id.editText_tenfile);
        final  EditText et_content = (EditText)findViewById(R.id.editText_nd);
        Button bt_moi = (Button)findViewById(R.id.button_nhap);
        bt_moi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_filename.setText("");
                et_content.setText("");
            }
        });
        final ArrayList<String> filenamelist = new ArrayList<>();
        filenamelist.add("Hello");
        final Spinner sp_filename = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,filenamelist);
        sp_filename.setAdapter(adapter);
        sp_filename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                et_filename.setText(filenamelist.get(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button bt_luu = (Button)findViewById(R.id.button_luu);
        bt_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_filename.getText().toString();
                filenamelist.add(filename);
                try{
                   /* FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
                    fout.write(et_content.getText().toString().getBytes());
                    fout.close();*/
                    SharedPreferences pref = getApplicationContext().getSharedPreferences(filename, 0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("content",et_content.getText().toString());
                    editor.commit();

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Lỗi lưu file",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button bt_mo = (Button)findViewById(R.id.button_mo);
        bt_mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_filename.getText().toString();
                StringBuffer buffer = new StringBuffer();
                String line = null;
                try{
                  /*  FileInputStream fin = openFileInput(filename);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while ((line = br.readLine())!=null)
                        buffer.append(line).append("\n");
                    et_content.setText(buffer.toString());*/
                  SharedPreferences pref = getApplicationContext().getSharedPreferences(filename,0);
                  et_content.setText(pref.getString("content",null));

                }catch (Exception e){

                }
            }
        });
    }
}
