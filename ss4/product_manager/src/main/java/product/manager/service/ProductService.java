package product.manager.service;

import product.manager.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone1", 1000, "Iphone 14 promax", "Apple"));
        products.add(new Product(2, "Iphone", 900, "Iphone 14 ", "Apple"));
        products.add(new Product(3, "Iphone", 800, "Iphone 10", "Apple"));
        products.add(new Product(4, "Iphone", 700, "Iphone XS", "Apple"));
        products.add(new Product(5, "Iphone", 600, "Iphone 8", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (Product item: products) {
            if (item.getId()==product.getId()){
                item.setName(product.getName());
                item.setPrice(product.getPrice());
                item.setDescribe(product.getDescribe());
                item.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id){
                products.remove(i);
            }
        }

    }

    @Override
    public List<Product> findProduct(String name) {
        List<Product> productsFounded = new ArrayList<>();
        for (Product productName : products) {
            if (productName.getName().equals(name)) {
                productsFounded.add(productName);
            }
        }
        return productsFounded;
    }
}

