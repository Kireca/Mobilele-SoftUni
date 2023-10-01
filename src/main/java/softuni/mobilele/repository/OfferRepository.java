package softuni.mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.model.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
