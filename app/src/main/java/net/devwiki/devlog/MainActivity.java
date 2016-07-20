package net.devwiki.devlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.devwiki.log.DevLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DevLog.d("test log");
    }
}
