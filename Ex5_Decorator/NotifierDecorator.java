package decorator;


public abstract class NotifierDecorator implements Notifier {

    protected final Notifier wrapped;

    protected NotifierDecorator(Notifier notifier) {
        this.wrapped = notifier;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
    }
}
