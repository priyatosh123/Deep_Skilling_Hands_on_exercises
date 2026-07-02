package di;


public class DITest {

    static class MockCustomerRepository implements CustomerRepository {
        @Override
        public String findCustomerById(int id) {
            return "MockUser_" + id;
        }

        @Override
        public boolean exists(int id) {
            return id > 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Real Repository ---");
        CustomerRepository realRepo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(realRepo);

        service.printCustomerInfo(1);
        service.printCustomerInfo(3);
        service.printCustomerInfo(99);   // not found

        System.out.println("\n--- Mock Repository (simulating unit test) ---");
        CustomerService testService = new CustomerService(new MockCustomerRepository());

        testService.printCustomerInfo(7);
        testService.printCustomerInfo(42);
    }
}
