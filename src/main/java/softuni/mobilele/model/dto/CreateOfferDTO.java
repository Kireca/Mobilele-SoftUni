package softuni.mobilele.model.dto;

import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;

public record CreateOfferDTO(

        String description,
        Long modelId,
        EngineEnum engine,
        TransmissionEnum transmissionEnum,
        String imageURL,
        long mileage,
        BigDecimal price,
        int year

) {
}
