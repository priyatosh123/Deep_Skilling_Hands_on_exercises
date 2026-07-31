package proxy;


public class RealImage implements Image {

    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from remote server: " + filename);
        // Simulate network delay
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + filename);
    }
}
