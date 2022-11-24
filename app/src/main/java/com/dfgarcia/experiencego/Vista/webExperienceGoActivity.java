package com.dfgarcia.experiencego.Vista;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.dfgarcia.experiencego.R;

public class webExperienceGoActivity extends AppCompatActivity {

    private WebView myWebView ;
    private WebSettings myWebSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_experience_go);

        myWebView = (WebView) findViewById(R.id.webExperienceGo);
        myWebSettings = myWebView.getSettings();
        myWebSettings.setJavaScriptEnabled(true);
        myWebSettings.setDomStorageEnabled(true);
        myWebView.loadUrl("http://travorium.com/931511");
        myWebView.setWebViewClient(new WebViewClient());

        //https://travorium.com/931511
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}