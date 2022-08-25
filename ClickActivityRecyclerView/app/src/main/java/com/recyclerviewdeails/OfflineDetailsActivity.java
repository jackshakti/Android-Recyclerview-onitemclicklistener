package com.recyclerviewdeails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class OfflineDetailsActivity extends AppCompatActivity {

    private ImageView img;
    private TextView tv_name, tv_email;

    //webview
    private WebView WvDetails;
    //String url = "https://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline_activity_details);

//webview
        WvDetails = (WebView) findViewById(R.id.WvDetails);
        WvDetails.setWebViewClient(new MyBrowser());
//webview

        img = findViewById(R.id.id_img_details);
        tv_name = findViewById(R.id.id_name_details);
        tv_email = findViewById(R.id.id_email_details);


        img.setImageResource(getIntent().getIntExtra("imagINTENT", R.drawable.ic_img_01));
        tv_name.setText(getIntent().getStringExtra("nameINTENT"));
        tv_email.setText(getIntent().getStringExtra("emailINTENT"));


        //webview
        // getting data from the main Activity
        Intent intent = getIntent();
        String feedbackUrl = intent.getStringExtra("emailINTENT");

        //String url = "https://www.google.com/";
//        Log.e(TAG,"onResponse: feedback url :"+feedbackUrl);

        WvDetails.getSettings().setLoadsImagesAutomatically(true);
        WvDetails.getSettings().setJavaScriptEnabled(true);
        WvDetails.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WvDetails.loadUrl(feedbackUrl);
//webview

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}