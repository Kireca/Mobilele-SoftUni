package softuni.mobilele.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CreateOfferDTO {

    @NotEmpty
    @Size(min = 5, max = 512)
    String description;


    @Positive
    @NotNull

    Long modelId;

    @NotNull
    EngineEnum engine;


    @NotNull
    TransmissionEnum transmissionEnum;

    @NotEmpty
    String imageURL;

    @Positive
    @NotNull
    long mileage;

    @Positive
    @NotNull
    BigDecimal price;

    @NotNull(message = "Year must be provided")
    @Min(1930)
    Integer year;


}
