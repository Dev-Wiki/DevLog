package net.devwiki.log;

/**
 * 存放常量
 * Created by Asia on 2015/11/27 0027.
 */
interface Constant {

    /**
     * 日志保存的默认位置
     */
    String DEFAULT_SAVE_PATH = "";

    String HEAD_LINE = "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    String START_LINE = "┃";
    String FOOT_LINE = "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";

    /**
     * 日志级别
     */
    interface LogLevel {
        /*** 日志级别:输出VERBOSE,DEBUG,INFO,WARN,ERROR级别日志 */
        int VERBOSE = 1;
        /*** 日志级别:输出DEBUG,INFO,WARN,ERROR级别日志 */
        int DEBUG = 2;
        /*** 日志级别:输出INFO,WARN,ERROR级别日志 */
        int INFO = 3;
        /*** 日志级别:输出WARN,ERROR级别日志 */
        int WARN = 4;
        /*** 日志级别:输出ERROR级别日志 */
        int ERROR = 5;
        /*** 日志级别:不输出日志 */
        int NONE = 6;
    }
}
