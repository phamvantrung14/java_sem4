package springboot_bootstrap.springboot_bootstrap.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot_bootstrap.springboot_bootstrap.entity.User;


public interface UserModel extends CrudRepository<User,Integer> {
}
