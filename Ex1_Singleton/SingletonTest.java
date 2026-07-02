package singleton;


public class SingletonTest {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");
        logger2.log("User logged in");
        logger1.log("Processing request");

        System.out.println("\n--- Verification ---");
        System.out.println("Same instance? " + (logger1 == logger2));
        System.out.println("Total logs: " + logger2.getLogCount());
    }
}
