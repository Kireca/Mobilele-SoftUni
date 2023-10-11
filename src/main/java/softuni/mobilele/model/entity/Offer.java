package softuni.mobilele.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {


    @NotNull
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @ManyToOne
    private Model model;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmissionEnum;

    @NotEmpty
    private String imageURL;

    @Positive
    @Column(nullable = false)
    private long mileage;

    @NotNull
    @Column(nullable = false)
    private BigDecimal price;

    @Min(1930)
    private int year;

    public UUID uuid() {
        return uuid;
    }

    public Offer setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String description() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Model model() {
        return model;
    }

    public Offer setModel(Model model) {
        this.model = model;
        return this;
    }

    public EngineEnum engine() {
        return engine;
    }

    public Offer setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum transmissionEnum() {
        return transmissionEnum;
    }

    public Offer setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
        return this;
    }

    public String imageURL() {
        return imageURL;
    }

    public Offer setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public long mileage() {
        return mileage;
    }

    public Offer setMileage(long mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal price() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int year() {
        return year;
    }

    public Offer setYear(int year) {
        this.year = year;
        return this;
    }
}
