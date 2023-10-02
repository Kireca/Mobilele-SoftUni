package softuni.mobilele.service.impl;

import org.springframework.stereotype.Service;
import softuni.mobilele.model.dto.CreateOfferDTO;
import softuni.mobilele.repository.OfferRepository;
import softuni.mobilele.service.BrandService;
import softuni.mobilele.service.OfferService;

import java.util.UUID;


@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        //TODO - create offer
        throw new UnsupportedOperationException("Coming soon!");
    }
}
