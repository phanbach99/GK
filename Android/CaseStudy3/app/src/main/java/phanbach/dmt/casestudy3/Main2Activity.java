package phanbach.dmt.casestudy3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText et_hoten,et_namsinh;
    Button bt_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_hoten = (EditText)findViewById(R.id.editText_hoten);
        et_namsinh = (EditText)findViewById(R.id.editText_namsinh);
        bt_submit = (Button)findViewById(R.id.button_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("trave_ht",et_hoten.getText().toString());
                intent.putExtra("trave_ns",et_namsinh.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
