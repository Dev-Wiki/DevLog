package net.devwiki.log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 用于打印Json
 * Created by Asia on 2015/11/27 0027.
 */
class JsonLog {

    private static int logLevel = Constant.LogLevel.DEBUG;

    public static void setLogLevel(int level) {
        JsonLog.logLevel = level;
    }

    public static void print(String tag, String header, String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String msg = jsonObject.toString(4);
            BaseLog.print(logLevel, tag, Constant.HEAD_LINE);
            BaseLog.print(logLevel, tag, Constant.START_LINE + "\r" + header);
            String[] msgs = msg.split("\\n");
            for (String str : msgs) {
                BaseLog.print(logLevel, tag,Constant.START_LINE + "\r" + str);
            }
            BaseLog.print(logLevel, tag, Constant.FOOT_LINE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
