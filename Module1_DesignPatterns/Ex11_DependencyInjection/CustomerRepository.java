package di;


public interface CustomerRepository {
    String findCustomerById(int id);
    boolean exists(int id);
}
