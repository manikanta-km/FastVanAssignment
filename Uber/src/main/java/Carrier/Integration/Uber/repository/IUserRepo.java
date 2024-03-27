package Carrier.Integration.Uber.repository;

import Carrier.Integration.Uber.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);

}
