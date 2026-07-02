package decorator;


public class DecoratorTest {

    public static void main(String[] args) {
        // Email only
        Notifier emailOnly = new EmailNotifier("user@example.com");

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(
                new EmailNotifier("user@example.com"),
                "+91-9876543210"
        );

        // Email + SMS + Slack (all three channels)
        Notifier allChannels = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier("user@example.com"),
                        "+91-9876543210"
                ),
                "alerts"
        );

        System.out.println("--- Email only ---");
        emailOnly.send("Server is down!");

        System.out.println("\n--- Email + SMS ---");
        emailAndSMS.send("Deployment completed.");

        System.out.println("\n--- All channels ---");
        allChannels.send("Critical: DB unreachable.");
    }
}
