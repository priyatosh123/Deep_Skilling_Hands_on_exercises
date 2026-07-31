import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testGetUserById() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getUserById(1)).thenReturn("Priyatosh Kumar");
        when(mockApi.getUserById(2)).thenReturn("Riya Sharma");

        MyService service = new MyService(mockApi);

        assertEquals("Priyatosh Kumar", service.fetchUser(1));
        assertEquals("Riya Sharma", service.fetchUser(2));
    }

    @Test
    public void testApiReturnsNull() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn(null);

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertNull(result);
    }

    @Test
    public void testApiReturnsEmptyString() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("", result);
        assertTrue(result.isEmpty());
    }
}
