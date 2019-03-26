package factories;

import logger.FileLogger;
import logger.Loggable;

public class LoggerFactory {

    public static Loggable getLogget(){
        return new FileLogger();
    }
}
