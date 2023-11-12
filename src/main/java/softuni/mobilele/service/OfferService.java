package softuni.mobilele.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import softuni.mobilele.model.dto.CreateOfferDTO;
import softuni.mobilele.model.dto.OfferDetailDTO;
import softuni.mobilele.model.dto.OfferSummaryDTO;

import java.util.Optional;
import java.util.UUID;


public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

    Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID);

    void deleteOffer(UUID offerUUID);
}
