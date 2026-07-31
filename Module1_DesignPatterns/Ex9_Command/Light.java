package command;

/**
 * Receiver — knows how to actually do the work.
 */
public class Light {

    private final String location;
    private boolean on;

    public Light(String location) {
        this.location = location;
        this.on = false;
    }

    public void turnOn() {
        on = true;
        System.out.println(location + " light is ON.");
    }

    public void turnOff() {
        on = false;
        System.out.println(location + " light is OFF.");
    }

    public boolean isOn() {
        return on;
    }
}
