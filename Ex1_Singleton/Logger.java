package singleton;


public class Logger {

    private static volatile Logger instance;
    private int logCount;

    // Private constructor prevents direct instantiation
    private Logger() {
        logCount = 0;
        System.out.println("Logger initialized.");
    }

    
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}
