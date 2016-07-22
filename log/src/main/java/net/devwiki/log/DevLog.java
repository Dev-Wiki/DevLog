package net.devwiki.log;

import android.text.TextUtils;
import net.devwiki.log.Constant.*;

/**
 * 日志类<br/>
 * 若不调用{@link DevLog#init(int, int, String)},则默认打印所有级别日志并保存{@link Constant#WARN}级别以上的日志
 * 到{@link Constant#DEFAULT_SAVE_PATH}.
 * Created by Asia on 2015/11/27 0027.
 */
public class DevLog {

    private static String className;			//所在的类名
    private static String methodName;			//所在的方法名
    private static int lineNumber;				//所在行号

    //输出日志的级别
    private static int logLevel = LogLevel.VERBOSE;
    //保存日志的级别
    private static int saveLevel = LogLevel.WARN;
    //保存文件的路径
    private static String savePath = Constant.DEFAULT_SAVE_PATH;

    private DevLog(){
        //禁止实例化
    }

    /**
     * 初始化日志类
     * @param logLevel 日志在Logcat输出的级别,参见{@link DevLog#setLogLevel(int)}
     * @param saveLevel 保存到文件的日志级别,参见{@link DevLog#setSaveLevel(int)}
     * @param savePath 日志文件保存路径,设置为绝对路径,默认保存在{@link Constant#DEFAULT_SAVE_PATH}
     */
    public static void init(int logLevel, int saveLevel, String savePath){
        DevLog.logLevel = logLevel;
        DevLog.saveLevel = saveLevel;
        if (!TextUtils.isEmpty(savePath)) {
            DevLog.savePath = savePath;
        }
    }

    /**
     * 设置Logcat输出日志的级别
     * @param logLevel 日志级别,可设置为:{@link Constant#VERBOSE}, {@link Constant#DEBUG}, {@link Constant#INFO},
     *                 {@link Constant#WARN},{@link Constant#ERROR}, {@link Constant#NONE}
     */
    public static void setLogLevel(int logLevel) {
        DevLog.logLevel = logLevel;
    }

    /**
     * 设置保存值文件的日志的级别
     * @param saveLevel 日志级别,可设置为:{@link Constant#VERBOSE}, {@link Constant#DEBUG}, {@link Constant#INFO},
     *                 {@link Constant#WARN},{@link Constant#ERROR}, {@link Constant#NONE}
     */
    public static void setSaveLevel(int saveLevel) {
        DevLog.saveLevel = saveLevel;
    }

    /**
     * 设置日志文件保存路径
     * @param savePath 文件路径
     */
    public static void setSavePath(String savePath) {
        DevLog.savePath = savePath;
    }

    public static void v(String msg){
        if (logLevel <= LogLevel.VERBOSE ){
            getLocationInfo(new Throwable().getStackTrace());
            printLog(LogType.BASE_LOG, LogLevel.VERBOSE, className, createLogWithoutClassName(msg));
        }
    }

    public static void v(String tag, String msg){
        if (logLevel <= LogLevel.VERBOSE){
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                printLog(LogType.BASE_LOG, LogLevel.VERBOSE, className, createLogWithoutClassName(msg));
            } else {
                printLog(LogType.BASE_LOG, LogLevel.VERBOSE, tag, createLogWithClassName(msg));
            }
        }
    }

    public static void d(String msg){
        if (logLevel <= LogLevel.DEBUG ){
            getLocationInfo(new Throwable().getStackTrace());
            printLog(LogType.BASE_LOG, LogLevel.DEBUG, className, createLogWithoutClassName(msg));
        }
    }

    public static void d(String tag, String msg){
        if (logLevel <= LogLevel.DEBUG){
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                printLog(LogType.BASE_LOG, LogLevel.DEBUG, className, createLogWithoutClassName(msg));
            } else {
                printLog(LogType.BASE_LOG, LogLevel.DEBUG, tag, createLogWithClassName(msg));
            }
        }
    }

    public static void i(String msg){
        if (logLevel <= LogLevel.INFO ){
            getLocationInfo(new Throwable().getStackTrace());
            printLog(LogType.BASE_LOG, LogLevel.INFO, className, createLogWithoutClassName(msg));
        }
    }

    public static void i(String tag, String msg){
        if (logLevel <= LogLevel.INFO ){
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                printLog(LogType.BASE_LOG, LogLevel.INFO, className, createLogWithoutClassName(msg));
            } else {
                printLog(LogType.BASE_LOG, LogLevel.INFO, tag, createLogWithClassName(msg));
            }
        }
    }

    public static void w(String msg){
        if (logLevel <= LogLevel.WARN ){
            getLocationInfo(new Throwable().getStackTrace());
            printLog(LogType.BASE_LOG, LogLevel.WARN, className, createLogWithoutClassName(msg));
        }
    }

    public static void w(String tag, String msg){
        if (logLevel <= LogLevel.WARN){
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                printLog(LogType.BASE_LOG, LogLevel.WARN, className, createLogWithoutClassName(msg));
            } else {
                printLog(LogType.BASE_LOG, LogLevel.WARN, tag, createLogWithClassName(msg));
            }
        }
    }

    public static void e(String msg){
        if (logLevel <= LogLevel.ERROR ){
            getLocationInfo(new Throwable().getStackTrace());
            printLog(LogType.BASE_LOG, LogLevel.ERROR, className, createLogWithoutClassName(msg));
        }
    }

    public static void e(String tag, String msg){
        if (logLevel <= LogLevel.ERROR){
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                printLog(LogType.BASE_LOG, LogLevel.ERROR, className, createLogWithoutClassName(msg));
            } else {
                printLog(LogType.BASE_LOG, LogLevel.ERROR, tag, createLogWithClassName(msg));
            }
        }
    }

    private static void printLog(int type, int level, String tag, String msg){
        switch (type){
            case LogType.BASE_LOG:
                BaseLog.print(level, tag, msg);
                break;
            case LogType.JSON:
                // TODO: 2015/11/28 打印JSON
                break;
            case LogType.XML:
                // TODO: 2016/7/22 打印XML
                break;
            default:
                break;
        }
    }

    private static String createLogWithClassName(String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(className);
        builder.append("#");
        builder.append(methodName);
        builder.append(":");
        builder.append(lineNumber);
        builder.append("]");
        builder.append(msg);
        return builder.toString();
    }

    private static String createLogWithoutClassName(String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(methodName);
        builder.append(":");
        builder.append(lineNumber);
        builder.append("]");
        builder.append(msg);
        return builder.toString();
    }

    private static void getLocationInfo(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        int index = className.indexOf(".");
        if (index > -1) {
            className = className.substring(0, index);
        }
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }
}
