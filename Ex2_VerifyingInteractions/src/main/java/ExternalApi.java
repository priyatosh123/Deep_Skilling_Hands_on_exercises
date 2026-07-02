public interface ExternalApi {
    String getData();
    String getUserById(int id);
    void sendNotification(String message);
}
