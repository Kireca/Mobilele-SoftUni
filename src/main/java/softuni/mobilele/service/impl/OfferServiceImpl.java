package softuni.mobilele.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.mobilele.model.dto.CreateOfferDTO;
import softuni.mobilele.model.dto.OfferDetailDTO;
import softuni.mobilele.model.dto.OfferSummaryDTO;
import softuni.mobilele.model.entity.ModelEntity;
import softuni.mobilele.model.entity.OfferEntity;
import softuni.mobilele.repository.ModelRepository;
import softuni.mobilele.repository.OfferRepository;
import softuni.mobilele.service.OfferService;

import java.util.Optional;
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

        ModelEntity modelEntity = modelRepository
                .findById(createOfferDTO.getModelId())
                .orElseThrow(() -> new IllegalArgumentException("Model with id " + createOfferDTO.getModelId() + "not found!"));
        newOfferEntity.setModel(modelEntity);

        newOfferEntity = offerRepository.save(newOfferEntity);
        return newOfferEntity.getUuid();
    }

    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {
        return offerRepository
                .findAll(pageable)
                .map(OfferServiceImpl::mapAsSummary);
    }

    @Override
    public Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID) {
        return offerRepository.findByUuid(offerUUID)
                .map(OfferServiceImpl::mapAsDetails);
    }

    @Override
    @Transactional
    public void deleteOffer(UUID offerUUID) {
        offerRepository.deleteByUuid(offerUUID);
    }


    private static OfferDetailDTO mapAsDetails(OfferEntity offerEntity) {
        return new OfferDetailDTO(
                //TODO reuse
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBrand().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getYear(),
                offerEntity.getMileage(),
                offerEntity.getPrice(),
                offerEntity.getEngine(),
                offerEntity.getTransmission(),
                offerEntity.getImageURL());
    }

    private static OfferSummaryDTO mapAsSummary(OfferEntity offerEntity) {
        return new OfferSummaryDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBrand().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getYear(),
                offerEntity.getMileage(),
                offerEntity.getPrice(),
                offerEntity.getEngine(),
                offerEntity.getTransmission(),
                offerEntity.getImageURL());
    }

    private OfferEntity map(CreateOfferDTO createOfferDTO) {
        return new OfferEntity()
                .setUuid(UUID.randomUUID())
                .setDescription(createOfferDTO.getDescription())
                .setEngine(createOfferDTO.getEngine())
                .setTransmission(createOfferDTO.getTransmission())
                .setImageURL(createOfferDTO.getImageURL())
                .setMileage(createOfferDTO.getMileage())
                .setPrice(createOfferDTO.getPrice())
                .setYear(createOfferDTO.getYear());
    }
}
