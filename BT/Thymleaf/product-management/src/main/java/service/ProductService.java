package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "John", 20.00, "Hanoi"));
        products.put(2, new Product(2, "Bill", 30.00, "Danang"));
        products.put(3, new Product(3, "Alex", 40.00, "Saigon"));
        products.put(4, new Product(4, "Adam", 50.00, "Beijin"));
        products.put(5, new Product(5, "Sophia", 60.00, "Miami"));
        products.put(6, new Product(6, "Rose", 70.00, "Newyork"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
