package decorator;

public class SlackNotifierDecorator extends NotifierDecorator {

    private final String slackChannel;

    public SlackNotifierDecorator(Notifier notifier, String channel) {
        super(notifier);
        this.slackChannel = channel;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Slack #" + slackChannel + ": " + message);
    }
}
