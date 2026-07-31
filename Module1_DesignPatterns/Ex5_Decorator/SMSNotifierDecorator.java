package decorator;

public class SMSNotifierDecorator extends NotifierDecorator {

    private final String phoneNumber;

    public SMSNotifierDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("SMS to [" + phoneNumber + "]: " + message);
    }
}
