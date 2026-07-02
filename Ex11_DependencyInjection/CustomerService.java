package di;


public class CustomerService {

    private final CustomerRepository repo;

    
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public String getCustomer(int id) {
        if (!repo.exists(id)) {
            return "No customer found with ID: " + id;
        }
        return repo.findCustomerById(id);
    }

    public void printCustomerInfo(int id) {
        System.out.println("Customer [ID=" + id + "]: " + getCustomer(id));
    }
}
