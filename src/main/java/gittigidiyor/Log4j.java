package gittigidiyor;

import org.apache.log4j.Logger;

public class Log4j {

    private static Logger Log = Logger.getLogger(Log4j.class.getName());

    public static void startLog() {
        Log.info("Test is starting...");
    }

    public static void endLog() {
        Log.info("Test is ending...");
    }

    public static void info(String message) {
        Log.info(message);
    }

}

