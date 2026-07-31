package org.example;

public interface ExternalApi {
    String getData();
    String processUser(String userId);
    void saveData(String data);
    void logActivity(String acitvity);
}
