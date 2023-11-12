package softuni.mobilele.model.dto;

import java.math.BigDecimal;

import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.model.enums.TransmissionEnum;

public record OfferSummaryDTO(
        String uuid,
        String brand,
        String model,
        int year,
        Long mileage,
        BigDecimal price,
        EngineEnum engine,
        TransmissionEnum transmission,
        String imageUrl
) {
    public String summary() {
        return brand + " " + model + ", " + year;
    }
}