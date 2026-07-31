package di;

import java.util.HashMap;
import java.util.Map;


public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<Integer, String> store = new HashMap<>();

    public CustomerRepositoryImpl() {
        store.put(1, "Priyatosh Kumar");
        store.put(2, "Riya Sharma");
        store.put(3, "Arjun Verma");
        store.put(4, "Meena Patel");
    }

    @Override
    public String findCustomerById(int id) {
        return store.getOrDefault(id, null);
    }

    @Override
    public boolean exists(int id) {
        return store.containsKey(id);
    }
}
