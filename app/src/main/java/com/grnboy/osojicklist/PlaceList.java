package com.grnboy.osojicklist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import jp.liveAid.LiveAidWebView;


public class PlaceList extends ActionBarActivity implements View.OnClickListener {

    private LiveAidWebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(this);

        wv = (LiveAidWebView)findViewById(R.id.liveaidad);
        wv.setWebViewClient(new CustomWebView());
        wv.setAidId("oosojicklst");
        wv.setBgColor("#FF0000");
        wv.setRefreshInterval(3000);
        wv.loadAd();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_place_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Guide0001.class);
        startActivity(intent);
    }

    private class CustomWebView extends WebViewClient {
        @Override
        public void onPageFinished(WebView View,String url) {
            wv.loadAdOnLoad();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

            return true;
        }
    }
}


