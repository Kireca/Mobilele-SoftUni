package softuni.mobilele.service.impl;

import org.springframework.stereotype.Service;
import softuni.mobilele.model.dto.CreateOfferDTO;
import softuni.mobilele.model.entity.ModelEntity;
import softuni.mobilele.model.entity.OfferEntity;
import softuni.mobilele.repository.ModelRepository;
import softuni.mobilele.repository.OfferRepository;
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

        OfferEntity newOfferEntity = map(createOfferDTO);

        ModelEntity modelEntity = modelRepository.findById(createOfferDTO
                        .getModelId())
                .orElseThrow(() -> new IllegalArgumentException("Model with id " + createOfferDTO.getModelId() + "not found!"));
        newOfferEntity.setModelEntity(modelEntity);


        newOfferEntity = offerRepository.save(newOfferEntity);
        return newOfferEntity.getUuid();
    }

    private OfferEntity map(CreateOfferDTO createOfferDTO) {
        return new OfferEntity().setUuid(UUID.randomUUID())
                .setDescription(createOfferDTO.getDescription())
                .setEngine(createOfferDTO.getEngine())
                .setTransmissionEnum(createOfferDTO.getTransmissionEnum())
                .setMileage(createOfferDTO.getMileage())
                .setPrice(createOfferDTO.getPrice())
                .setYear(createOfferDTO.getYear());
    }
}
