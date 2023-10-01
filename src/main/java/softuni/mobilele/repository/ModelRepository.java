package softuni.mobilele.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.model.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
