package softuni.mobilele.service;

import softuni.mobilele.model.dto.CreateOfferDTO;

import java.util.UUID;


public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);
}
