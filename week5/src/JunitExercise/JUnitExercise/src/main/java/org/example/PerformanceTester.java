package org.example;

public class PerformanceTester {

    public void performTask() {
        try {
            // Simulate a task that takes 200 milliseconds to complete
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}