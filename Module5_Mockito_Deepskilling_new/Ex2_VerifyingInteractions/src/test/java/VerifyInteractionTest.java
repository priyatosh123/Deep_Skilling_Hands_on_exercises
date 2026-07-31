import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class VerifyInteractionTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void testVerifyGetUserCalledWithCorrectId() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchUser(5);

        verify(mockApi).getUserById(5);
    }

    @Test
    public void testVerifyMethodCalledExactTimes() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();
        service.fetchData();
        service.fetchData();

        verify(mockApi, times(3)).getData();
    }

    @Test
    public void testVerifyMethodNeverCalled() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi, never()).sendNotification(anyString());
    }

    @Test
    public void testVerifyNotificationSentWithMessage() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.notifyUser("Your order is confirmed");

        verify(mockApi).sendNotification("Your order is confirmed");
    }

    @Test
    public void testNoMoreInteractionsAfterFetch() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
        verifyNoMoreInteractions(mockApi);
    }
}
