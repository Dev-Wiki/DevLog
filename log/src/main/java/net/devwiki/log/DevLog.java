package net.devwiki.log;

import android.text.TextUtils;

import net.devwiki.log.Constant.*;

/**
 * 日志类<br/>
 * 若不调用{@link DevLog#init(int, int, String)},则默认打印所有级别日志并保存{@link LogLevel#WARN}级别以上的日志
 * 到{@link Constant#DEFAULT_SAVE_PATH}.
 * Created by DevWiki on 2015/11/27 0027.
 */
public class DevLog {

    private static String className;            //所在的类名
    private static String methodName;            //所在的方法名
    private static int lineNumber;                //所在行号

    //输出日志的级别
    private static int logLevel = LogLevel.VERBOSE;
    //保存日志的级别
    private static int saveLevel = LogLevel.WARN;
    //保存文件的路径
    private static String savePath = Constant.DEFAULT_SAVE_PATH;

    private DevLog() {
        //禁止实例化
    }

    /**
     * 初始化日志类
     *
     * @param logLevel  日志在Logcat输出的级别,参见{@link DevLog#setLogLevel(int)}
     * @param saveLevel 保存到文件的日志级别,参见{@link DevLog#setSaveLevel(int)}
     * @param savePath  日志文件保存路径,设置为绝对路径,默认保存在{@link Constant#DEFAULT_SAVE_PATH}
     */
    public static void init(int logLevel, int saveLevel, String savePath) {
        DevLog.logLevel = logLevel;
        DevLog.saveLevel = saveLevel;
        if (!TextUtils.isEmpty(savePath)) {
            DevLog.savePath = savePath;
        }
    }

    /**
     * 设置Logcat输出日志的级别
     *
     * @param logLevel 日志级别,可设置为:{@link LogLevel#VERBOSE}, {@link LogLevel#DEBUG}, {@link LogLevel#INFO},
     *                 {@link LogLevel#WARN},{@link LogLevel#ERROR}, {@link LogLevel#NONE}
     */
    public static void setLogLevel(int logLevel) {
        DevLog.logLevel = logLevel;
    }

    /**
     * 设置保存值文件的日志的级别
     *
     * @param saveLevel 日志级别,可设置为:{@link LogLevel#VERBOSE}, {@link LogLevel#DEBUG}, {@link LogLevel#INFO},
     *                  {@link LogLevel#WARN},{@link LogLevel#ERROR}, {@link LogLevel#NONE}
     */
    public static void setSaveLevel(int saveLevel) {
        DevLog.saveLevel = saveLevel;
    }

    /**
     * 设置日志文件保存路径
     *
     * @param savePath 文件路径
     */
    public static void setSavePath(String savePath) {
        DevLog.savePath = savePath;
    }

    /**
     * 设置输出JSON时的日志级别
     *
     * @param level 日志级别，默认为Debug级别
     */
    public static void setJsonLevel(int level) {
        JsonLog.setLogLevel(level);
    }

    /**
     * 打印Verbose级别的日志
     *
     * @param msg 日志内容
     */
    public static void v(String msg) {
        if (logLevel <= LogLevel.VERBOSE) {
            getLocationInfo(new Throwable().getStackTrace());
            BaseLog.print(LogLevel.VERBOSE, className, createLogWithoutClassName(msg));
        }
    }

    /**
     * 打印Verbose级别的日志
     *
     * @param tag 打印时的TAG
     * @param msg 日志内容
     */
    public static void v(String tag, String msg) {
        if (logLevel <= LogLevel.VERBOSE) {
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                BaseLog.print(LogLevel.VERBOSE, className, createLogWithoutClassName(msg));
            } else {
                BaseLog.print(LogLevel.VERBOSE, tag, createLogWithClassName(msg));
            }
        }
    }

    /**
     * 打印Debug级别的日志
     *
     * @param msg 日志内容
     */
    public static void d(String msg) {
        if (logLevel <= LogLevel.DEBUG) {
            getLocationInfo(new Throwable().getStackTrace());
            BaseLog.print(LogLevel.DEBUG, className, createLogWithoutClassName(msg));
        }
    }

    /**
     * 打印Debug级别的日志
     *
     * @param tag 打印时的TAG
     * @param msg 日志内容
     */
    public static void d(String tag, String msg) {
        if (logLevel <= LogLevel.DEBUG) {
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                BaseLog.print(LogLevel.DEBUG, className, createLogWithoutClassName(msg));
            } else {
                BaseLog.print(LogLevel.DEBUG, tag, createLogWithClassName(msg));
            }
        }
    }

    /**
     * 打印Info级别的日志
     *
     * @param msg 日志内容
     */
    public static void i(String msg) {
        if (logLevel <= LogLevel.INFO) {
            getLocationInfo(new Throwable().getStackTrace());
            BaseLog.print(LogLevel.INFO, className, createLogWithoutClassName(msg));
        }
    }

    /**
     * 打印Info级别的日志
     *
     * @param tag 打印时的TAG
     * @param msg 日志内容
     */
    public static void i(String tag, String msg) {
        if (logLevel <= LogLevel.INFO) {
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                BaseLog.print(LogLevel.INFO, className, createLogWithoutClassName(msg));
            } else {
                BaseLog.print(LogLevel.INFO, tag, createLogWithClassName(msg));
            }
        }
    }

    /**
     * 打印Warn级别的日志
     *
     * @param msg 日志内容
     */
    public static void w(String msg) {
        if (logLevel <= LogLevel.WARN) {
            getLocationInfo(new Throwable().getStackTrace());
            BaseLog.print(LogLevel.WARN, className, createLogWithoutClassName(msg));
        }
    }

    /**
     * 打印Warn级别的日志
     *
     * @param tag 打印时的TAG
     * @param msg 日志内容
     */
    public static void w(String tag, String msg) {
        if (logLevel <= LogLevel.WARN) {
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                BaseLog.print(LogLevel.WARN, className, createLogWithoutClassName(msg));
            } else {
                BaseLog.print(LogLevel.WARN, tag, createLogWithClassName(msg));
            }
        }
    }

    /**
     * 打印Error级别的日志
     *
     * @param msg 日志内容
     */
    public static void e(String msg) {
        if (logLevel <= LogLevel.ERROR) {
            getLocationInfo(new Throwable().getStackTrace());
            BaseLog.print(LogLevel.ERROR, className, createLogWithoutClassName(msg));
        }
    }

    /**
     * 打印Error级别的日志
     *
     * @param tag 打印时的TAG
     * @param msg 日志内容
     */
    public static void e(String tag, String msg) {
        if (logLevel <= LogLevel.ERROR) {
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                BaseLog.print(LogLevel.ERROR, className, createLogWithoutClassName(msg));
            } else {
                BaseLog.print(LogLevel.ERROR, tag, createLogWithClassName(msg));
            }
        }
    }

    /**
     * 打印Verbose级别的日志
     *
     * @param e 异常
     */
    public static void e(Exception e) {
        if (logLevel <= LogLevel.ERROR) {
            getLocationInfo(new Throwable().getStackTrace());
            BaseLog.print(LogLevel.ERROR, className, createLogWithoutClassName(e.getMessage()));
        }
    }

    /**
     * 打印Verbose级别的日志
     *
     * @param tag 打印时的TAG
     * @param e 异常
     */
    public static void e(String tag, Exception e) {
        if (logLevel <= LogLevel.ERROR) {
            getLocationInfo(new Throwable().getStackTrace());
            if (tag == null || tag.equals(className)) {
                BaseLog.print(LogLevel.ERROR, className, createLogWithoutClassName(e.getMessage()));
            } else {
                BaseLog.print(LogLevel.ERROR, tag, createLogWithClassName(e.getMessage()));
            }
        }
    }

    /**
     * 打印JSON内容日志
     *
     * @param json 日志内容
     */
    public static void json(String json) {
        if (logLevel <= LogLevel.ERROR) {
            getLocationInfo(new Throwable().getStackTrace());
            String location = createLogWithClassName("");
            JsonLog.print(className, location, json);
        }
    }

    /**
     * 打印JSON内容日志
     *
     * @param tag 打印时的TAG
     * @param json 日志内容
     */
    public static void json(String tag, String json) {
        if (logLevel <= LogLevel.ERROR) {
            getLocationInfo(new Throwable().getStackTrace());
            String location = createLogWithClassName("");
            JsonLog.print(tag, location, json);
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
