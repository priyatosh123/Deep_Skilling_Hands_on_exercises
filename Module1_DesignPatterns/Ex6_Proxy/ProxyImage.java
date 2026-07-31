package proxy;


public class ProxyImage implements Image {

    private final String filename;
    private RealImage cached;

    public ProxyImage(String filename) {
        this.filename = filename;
        this.cached = null;
    }

    @Override
    public void display() {
        if (cached == null) {
            System.out.println("[Proxy] Cache miss — fetching real image.");
            cached = new RealImage(filename);
        } else {
            System.out.println("[Proxy] Cache hit — using cached image.");
        }
        cached.display();
    }
}
