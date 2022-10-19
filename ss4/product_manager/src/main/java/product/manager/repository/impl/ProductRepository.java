package product.manager.repository.impl;

import org.springframework.stereotype.Repository;
import product.manager.model.Product;
import product.manager.repository.IProductRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {
//    private static final List<Product> products = new ArrayList<>();
    @PersistenceContext
    private EntityManager entityManager;

//    static {
//        products.add(new Product(1, "Iphone1", 1000, "Iphone 14 promax", "Apple"));
//        products.add(new Product(2, "Iphone", 900, "Iphone 14 ", "Apple"));
//        products.add(new Product(3, "Iphone", 800, "Iphone 10", "Apple"));
//        products.add(new Product(4, "Iphone", 700, "Iphone XS", "Apple"));
//        products.add(new Product(5, "Iphone", 600, "Iphone 8", "Apple"));
//    }
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("select p from Product as p ", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
       return entityManager.find(Product.class,id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(Product product) {
        product = entityManager.merge(product);
        entityManager.remove(product);

    }

    @Override
    public List<Product> findProduct(String name) {
        TypedQuery<Product> query = entityManager
                .createQuery("select p FROM Product as p WHERE p.name like :name", Product.class)
                .setParameter(name,"%"+name+"%");
        return query.getResultList();
    }
}
