package enrol.springbootenrol.repositories;

import enrol.springbootenrol.modeles.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long>{

}