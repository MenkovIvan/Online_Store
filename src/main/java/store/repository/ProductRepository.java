package store.repository;

import org.springframework.data.repository.CrudRepository;
import store.model.products.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    Product findByFullName(String fullName);
    List<Product> findProductsByCategory(String category);
    List<Product> findProductsByEmail(String email);
}
