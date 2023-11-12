package softuni.mobilele.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OfferDetailDTO {

    private String uuid;
    private String brand;
    private String model;
    private int year;
    private Long mileage;
    private BigDecimal price;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private String imageUrl;

    public String details() {
        return brand + " " + model + ", " + year;
    }
}
