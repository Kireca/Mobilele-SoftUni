package softuni.mobilele.service.impl;

import org.springframework.stereotype.Service;
import softuni.mobilele.model.dto.CreateOfferDTO;
import softuni.mobilele.model.entity.Model;
import softuni.mobilele.model.entity.Offer;
import softuni.mobilele.repository.ModelRepository;
import softuni.mobilele.repository.OfferRepository;
import softuni.mobilele.service.BrandService;
import softuni.mobilele.service.OfferService;

import java.util.UUID;


@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;

        this.modelRepository = modelRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        Offer newOffer = map(createOfferDTO);

        Model modelEntity = modelRepository.findById(createOfferDTO
                        .getModelId())
                .orElseThrow(() -> new IllegalArgumentException("Model with id " + createOfferDTO.getModelId() + "not found!"));
        newOffer.setModel(modelEntity);


        newOffer = offerRepository.save(newOffer);
        return newOffer.getUuid();
    }

    private Offer map(CreateOfferDTO createOfferDTO) {
        return new Offer().setUuid(UUID.randomUUID())
                .setDescription(createOfferDTO.getDescription())
                .setEngine(createOfferDTO.getEngine())
                .setTransmissionEnum(createOfferDTO.getTransmissionEnum())
                .setMileage(createOfferDTO.getMileage())
                .setPrice(createOfferDTO.getPrice())
                .setYear(createOfferDTO.getYear());
    }
}
