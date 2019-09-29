package com.example.demodangonngu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocation();
        this.setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);
        Button btn_change = (Button) findViewById(R.id.button_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });
    }

    private void showChangeLanguageDialog() {
        String[] list = {"English", "Franch", "Vietnam"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Choose Language");
        dialog.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (i) {
                    case 0: {
                        setLocation("en");
                        recreate();
                        break;
                    }
                    case 1: {
                        setLocation("fr");
                        recreate();
                        break;
                    }
                    case 2: {
                        setLocation("vi");
                        recreate();
                        break;
                    }
                    default:
                        dialogInterface.dismiss();

                }
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    private void setLocation(String language) {
        Locale locale = new Locale(language);
        locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Setting", Activity.MODE_PRIVATE).edit();
        editor.putString("My_lang", language);

        //editor.commit();
        editor.apply();

    }

    public void loadLocation() {
        SharedPreferences editor = getSharedPreferences("Setting", Activity.MODE_PRIVATE);
        String language = editor.getString("My_lang", "");
        setLocation(language);
    }

}
