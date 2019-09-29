package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
WebView web= (WebView)findViewById(R.id.web);
web.loadUrl("https://www.google.com/maps/@9.779349,105.6189045,11z?hl=vi-VN");
web.getSettings().setJavaScriptEnabled(true);
    }
}
