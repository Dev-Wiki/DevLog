package net.devwiki.log;

/**
 * 存放常量
 * Created by Asia on 2015/11/27 0027.
 */
public interface Constant {

    /**
     * 日志类型
     */
    interface LogType {
        /*** 日志类型:VERBOSE */
        int BASE_LOG = 1;
        /*** 日志类型:JSON */
        int JSON = 2;
        /*** 日志类型:XML */
        int XML = 3;
    }

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

    /**
     * 日志级别:输出VERBOSE,DEBUG,INFO,WARN,ERROR级别日志<br/>
     * 日志类型:VERBOSE
     */
    int VERBOSE = 1;

    /**
     * 日志级别:输出DEBUG,INFO,WARN,ERROR级别日志<br/>
     * 日志类型:DEBUG
     */
    int DEBUG = 2;

    /**
     * 日志级别:输出INFO,WARN,ERROR级别日志<br/>
     * 日志类型:INFO
     */
    int INFO = 3;

    /**
     * 日志级别:输出WARN,ERROR级别日志<br/>
     * 日志类型:WARN
     */
    int WARN = 4;

    /**
     * 日志级别:输出ERROR级别日志<br/>
     * 日志类型:ERROR
     */
    int ERROR = 5;

    /**
     * 日志级别:不输出日志
     */
    int NONE = 6;

    /**
     * 日志类型:JSON
     */
    int JSON = 7;

    /**
     * 日志保存的默认位置
     */
    String DEFAULT_SAVE_PATH = "";
}
