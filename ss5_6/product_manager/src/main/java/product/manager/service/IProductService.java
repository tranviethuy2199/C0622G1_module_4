package product.manager.service;

import product.manager.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(Product product);

    List<Product> findProduct(String searchName);
}
