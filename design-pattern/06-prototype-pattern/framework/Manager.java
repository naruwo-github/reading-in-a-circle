package framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        // register a prototype
        this.showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {
        // create a prototype instance
        Product product = showcase.get(prototypeName);
        return product;
    }
}