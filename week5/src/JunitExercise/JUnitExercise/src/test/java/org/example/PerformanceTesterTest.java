package org.example;

import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {

    @Test
    public void testPerformTask_TimeoutSuccess() {
        PerformanceTester tester = new PerformanceTester();

        // Assert that performTask() finishes WITHIN 1 second (1000ms)
        // Since it takes ~200ms, this test WILL PASS.
        assertTimeout(Duration.ofSeconds(1), () -> {
            tester.performTask();
        });
    }

    @Test
    public void testPerformTask_TimeoutFailure_Example() {
        PerformanceTester tester = new PerformanceTester();

        // Un-comment to see a timeout FAILURE:
        // Task takes 200ms, but we only give it 50ms!

        /*
        assertTimeout(Duration.ofMillis(50), () -> {
            tester.performTask();
        });
        */
    }
}