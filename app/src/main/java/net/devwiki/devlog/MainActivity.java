package net.devwiki.devlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.devwiki.log.DevLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DevLog.v("log v...");
        DevLog.v("tag", "log v...");
        DevLog.d("log d...");
        DevLog.d("tag", "log d...");
        DevLog.i("log i...");
        DevLog.i("tag", "log i...");
        DevLog.w("log w...");
        DevLog.w("tag", "log w...");
        DevLog.e("log e...");
        DevLog.e("tag", "log e...");
    }
}
