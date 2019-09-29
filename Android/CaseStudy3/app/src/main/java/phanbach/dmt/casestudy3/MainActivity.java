package phanbach.dmt.casestudy3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv_ketqua;
    Button bt_nhapthongtin,bt_ketthuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_ketqua = (TextView)findViewById(R.id.textView_ketqua);
        bt_nhapthongtin = (Button)findViewById(R.id.button_nhapthongtin);
        bt_ketthuc = (Button)findViewById(R.id.button_ketthuc);

        bt_nhapthongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,9999);
            }
        });
        bt_ketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 9999 && resultCode == RESULT_OK){
            String st = "Họ và tên: " + data.getStringExtra("trave_ht");
            st +="\n Năm sinh: "+data.getStringExtra("trave_ns");
            Calendar calendar = Calendar.getInstance();
            int namsinh = Integer.parseInt(data.getStringExtra("trave_ns"));
            st += "\n Tuổi: "+ ((calendar.getTime().getYear()+1900)-namsinh);
            tv_ketqua.setText(st);
        }
    }
}
