package store.repository;

import org.springframework.data.repository.CrudRepository;
import store.model.products.categories.Televisor;

public interface TelevisorRepository extends CrudRepository<Televisor,Integer> {
    Televisor findTelevisorById(Integer id);
}