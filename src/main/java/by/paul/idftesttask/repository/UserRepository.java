package by.paul.idftesttask.repository;

import by.paul.idftesttask.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends  CrudRepository<User, Long> {


}
