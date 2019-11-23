package store.repository;

import org.springframework.data.repository.CrudRepository;
import store.model.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    Product findByFullName(String fullName);
}
