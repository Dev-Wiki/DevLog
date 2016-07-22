package net.devwiki.log;

import android.util.Log;

/**
 * 用于打印普通日志
 * Created by DevWiki on 2015/11/27 0027.
 */
class BaseLog {

    /**
     * 打印普通日志
     * @param level 日志级别
     * @param tag 日志的TAG
     * @param msg 日志内容
     */
    static void print(int level, String tag, String msg){
        switch (level){
            case Constant.LogLevel.VERBOSE:
                Log.v(tag, msg);
                break;
            case Constant.LogLevel.DEBUG:
                Log.d(tag, msg);
                break;
            case Constant.LogLevel.INFO:
                Log.i(tag, msg);
                break;
            case Constant.LogLevel.WARN:
                Log.w(tag, msg);
                break;
            case Constant.LogLevel.ERROR:
                Log.e(tag, msg);
                break;
            default:
                break;
        }
    }
}
