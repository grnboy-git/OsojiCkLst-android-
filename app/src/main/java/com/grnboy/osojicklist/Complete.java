package com.grnboy.osojicklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import net.nend.android.NendAdInterstitial;


public class Complete extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NendAdInterstitial.loadAd(getApplicationContext(), "8c278673ac6f676dae60a1f56d16dad122e23516", 213206);
        NendAdInterstitial.showAd(this);
        setContentView(R.layout.activity_complete);

        Button btn = (Button)findViewById(R.id.button7);
        btn.setOnClickListener(this);




    }


    @Override
    protected void onResume() {
        super.onResume();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_complete, menu);
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
        Intent intent = new Intent(this, Top.class);
        NendAdInterstitial.showAd(this,213206);
        startActivity(intent);
    }

}
