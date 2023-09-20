package softuni.mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}