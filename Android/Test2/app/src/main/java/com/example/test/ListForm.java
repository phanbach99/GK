package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListForm extends AppCompatActivity {
    private ListView listview;
    private EditText etname,etemail,etaddress;
    private Button btadd,btsave;
    private List<Student>StudentDataList = new ArrayList<>();
    private ArrayAdapter<Student>adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_form);

        listview = findViewById(R.id.listview);
        etaddress=findViewById(R.id.editText_address);
        etemail=findViewById(R.id.editText_email);
        etname=findViewById(R.id.editText_name);
        btadd=findViewById(R.id.button_add);
        btsave=findViewById(R.id.bt_save);

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });
        adapter = new ArrayAdapter<Student>(this,0,StudentDataList){
            //crt o

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item,null);
                TextView tvname = convertView.findViewById(R.id.textViewname);
                TextView tvemail = convertView.findViewById(R.id.textViewemail);
                TextView tvdiachi = convertView.findViewById(R.id.textViewdiachi);
                Student s = StudentDataList .get(position);
                tvname.setText(s.getName());
                tvemail.setText(s.getEmail());
                tvdiachi.setText(s.getDiachi());
                return convertView;
            }
        };
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showInforStudent(i);
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteStudent(i);
                return false;
            }
        });
    }
    private void addStudent(){
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String address = etaddress.getText().toString();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email)|| TextUtils.isEmpty(address)){
            Toast.makeText(this,"Hãy nhập dữ liệu",Toast.LENGTH_SHORT).show();
            return;
        }
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setDiachi(address);
        StudentDataList.add(s);
        adapter.notifyDataSetChanged();
    }
    private void showInforStudent(int position){
        Student s = StudentDataList.get(position);
        Intent intent = new Intent(ListForm.this,InforStudentActivity.class);
        intent.putExtra("name",s.getName());
        intent.putExtra("email",s.getEmail());
        intent.putExtra("address", s.getDiachi());
        startActivity(intent);
    }
    private void deleteStudent(final int position){
        new AlertDialog.Builder(this)
                .setTitle("Delete student")
                .setMessage("Are you want delete student ???")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StudentDataList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("cancle",null)
                .show();

    }

}
