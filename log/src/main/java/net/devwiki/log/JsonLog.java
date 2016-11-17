package net.devwiki.log;

import org.json.JSONArray;
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
        String msg;
        try {
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                msg = jsonObject.toString(4);
            } else if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                msg = jsonArray.toString(4);
            } else {
                msg = json;
            }
        } catch (JSONException e) {
            msg = json;
        }
        BaseLog.print(logLevel, tag, Constant.HEAD_LINE);
        BaseLog.print(logLevel, tag, Constant.START_LINE + "\r" + header);
        String[] msgArray = msg.split("\\n");
        for (String str : msgArray) {
            BaseLog.print(logLevel, tag,Constant.START_LINE + "\r" + str);
        }
        BaseLog.print(logLevel, tag, Constant.FOOT_LINE);
    }

}
