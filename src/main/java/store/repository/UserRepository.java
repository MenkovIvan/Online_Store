package store.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import store.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
    User findUserByEmail(String email);
    Boolean existsUserByEmailAndPassword(String email, String password);
}
