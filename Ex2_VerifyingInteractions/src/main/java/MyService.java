public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchUser(int id) {
        return api.getUserById(id);
    }

    public void notifyUser(String message) {
        api.sendNotification(message);
    }
}
