package softuni.mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.model.entity.ExchangeRateEntity;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity,String> {

}
