package store.repository;

import org.springframework.data.repository.CrudRepository;
import store.model.products.categories.Telephone;

public interface TelephoneRepository extends CrudRepository<Telephone,Integer> {
}
