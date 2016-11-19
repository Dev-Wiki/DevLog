package net.devwiki.devlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.socks.library.KLog;

import net.devwiki.log.DevLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Button mNormalVBtn;
    private Button mNormalDBtn;
    private Button mNormalIBtn;
    private Button mNormalWBtn;
    private Button mNormalEBtn;
    private Button mJSONBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNormalVBtn = (Button) findViewById(R.id.normal_v_btn);
        mNormalDBtn = (Button) findViewById(R.id.normal_d_btn);
        mNormalIBtn = (Button) findViewById(R.id.normal_i_btn);
        mNormalWBtn = (Button) findViewById(R.id.normal_w_btn);
        mNormalEBtn = (Button) findViewById(R.id.normal_e_btn);
        mJSONBtn = (Button) findViewById(R.id.json_btn);

        mNormalVBtn.setOnClickListener(this);
        mNormalDBtn.setOnClickListener(this);
        mNormalIBtn.setOnClickListener(this);
        mNormalWBtn.setOnClickListener(this);
        mNormalEBtn.setOnClickListener(this);
        mJSONBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normal_v_btn:
                printVLog();
                break;
            case R.id.normal_d_btn:
                printDLog();
                break;
            case R.id.normal_i_btn:
                printILog();
                break;
            case R.id.normal_w_btn:
                printWLog();
                break;
            case R.id.normal_e_btn:
                printELog();
                break;
            case R.id.json_btn:
                printJSONLog();
                break;
        }
    }

    private void printVLog() {
        DevLog.v();
        DevLog.v("this is a v message!");
        DevLog.v(TAG, "this is a v message");
    }

    private void printDLog() {
        DevLog.d();
        DevLog.d("this is a d message!");
        DevLog.d(TAG, "this is a d message");

//        printStackInfo("MainActivity#printDLog", Thread.currentThread().getStackTrace());
        threadPrint();
        Inner inner = new Inner();
        inner.print();
        inner.threadPrint();
    }

    private void printILog() {
        DevLog.i();
        DevLog.i("this is a i message!");
        DevLog.i(TAG, "this is a i message");
    }

    private void printWLog() {
        DevLog.w();
        DevLog.w("this is a w message!");
        DevLog.w(TAG, "this is a w message");
    }

    private void printELog() {
        DevLog.e();
        DevLog.e("this is a e message!");
        DevLog.e(TAG, "this is a e message");
        DevLog.e(new RuntimeException("this is an exception!"));
        DevLog.e(TAG, new RuntimeException("this is an exception!"));
    }

    private void printJSONLog() {
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

        DevLog.json("Json");
    }

    private void threadPrint() {
        new Thread() {
            @Override
            public void run() {
                DevLog.d("MainActivity#threadPrint");
                KLog.d(TAG, "KLog");
            }
        }.start();
    }

    private static class Inner {

        public void print() {
            DevLog.d("MainActivity.Inner#print");
            KLog.d(TAG, "KLog");
        }

        public void threadPrint() {
            new Thread() {
                @Override
                public void run() {
                    DevLog.d("MainActivity.Inner#threadPrint");
                    KLog.d(TAG, "KLog");
                }
            }.start();
        }
    }
}
