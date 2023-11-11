package softuni.mobilele.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.model.entity.ModelEntity;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

//    List<ModelEntity> findAllByBrandId (Long id);
}
