package softuni.mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.model.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
