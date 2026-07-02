import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("Priyatosh", 1000.0);
        System.out.println("Test started - account initialized");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("Test finished - account cleared");
    }

    @Test
    public void testDeposit() {
        double depositAmount = 500.0;

        account.deposit(depositAmount);

        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        double withdrawAmount = 200.0;

        account.withdraw(withdrawAmount);

        assertEquals(800.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositAndWithdraw() {
        double depositAmount = 1000.0;
        double withdrawAmount = 300.0;

        account.deposit(depositAmount);
        account.withdraw(withdrawAmount);

        assertEquals(1700.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        double overdraftAmount = 5000.0;

        account.withdraw(overdraftAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDeposit() {
        account.deposit(-100.0);
    }

    @Test
    public void testOwnerName() {
        String expectedOwner = "Priyatosh";

        String actualOwner = account.getOwner();

        assertEquals(expectedOwner, actualOwner);
        assertNotNull(actualOwner);
    }
}
