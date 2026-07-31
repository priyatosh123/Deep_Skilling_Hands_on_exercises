package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockitoExercisesTest {
    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    public void setUp(){
        mockApi =Mockito.mock(ExternalApi.class);
        service=new MyService(mockApi);
    }

    @Test
    public  void ex1_MockingAndStubbing(){
        when(mockApi.getData()).thenReturn("MockData");

        String res=service.fetchData();

        assertEquals("Mock data",res);
    }

    @Test
    public void ex2_VerifyingInteractions(){
        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void ex3_ArgumentMatching(){
        when(mockApi.processUser(anyString())).thenReturn("User Profile loaded");

        String result=service.getUserInfo("USER_1234");

        assertEquals("User Profile Loaded",result);

        verify(mockApi).processUser(eq("User_1234"));
    }
    @Test
    public void exercise4_HandlingVoidMethods() {
        // doNothing() is the default for void methods on mocks, but writing it explicitly clarifies intent
        doNothing().when(mockApi).saveData(anyString());

        // Act
        service.save("Sample Payload");

        // Verify interaction occurred on the void method
        verify(mockApi).saveData("Sample Payload");
    }

    // ==========================================
    // Exercise 5: Multiple Returns (Consecutive Calls)
    // ==========================================
    @Test
    public void exercise5_MultipleReturns() {
        // Stub method to return "First Call", then "Second Call" on subsequent invocations
        when(mockApi.getData()).thenReturn("First Call", "Second Call");

        // Act & Assert First Call
        assertEquals("First Call", service.fetchData());

        // Act & Assert Second Call
        assertEquals("Second Call", service.fetchData());

        // Any subsequent calls will keep returning the last stubbed value ("Second Call")
        assertEquals("Second Call", service.fetchData());
    }

    @Test
    public void exercise6_VerifyingInteractionOrder() {
        // Act
        service.auditWorkflow("Alice");

        // Create InOrder verifier passing the mock(s) involved
        InOrder inOrder = inOrder(mockApi);

        // Verify that START was logged BEFORE END
        inOrder.verify(mockApi).logActivity("START: Alice");
        inOrder.verify(mockApi).logActivity("END: Alice");
    }

    @Test
    public void exercise7_VoidMethodExceptions() {
        // For void methods, syntax is doThrow(...).when(mock).method()
        doThrow(new RuntimeException("Database Offline"))
                .when(mockApi).saveData("Corrupted Data");

        // Assert that calling service.save("Corrupted Data") throws the expected exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.save("Corrupted Data");
        });

        assertEquals("Database Offline", exception.getMessage());

        // Verify interaction was still attempted
        verify(mockApi).saveData("Corrupted Data");
    }
}
