package net.devwiki.devlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.devwiki.log.DevLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        DevLog.e(new RuntimeException("exception!!!"));
        DevLog.e("tag", new RuntimeException("exception!!!"));

        try {
            JSONObject object = new JSONObject();
            object.put("name", "zhangsan");
            object.put("age", 12);
            JSONArray array = new JSONArray();
            for (int i = 0; i < 5; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type-" + i, i);
                array.put(jsonObject);
            }
            object.put("score", array);
            DevLog.json(object.toString());
            DevLog.json("tag", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
