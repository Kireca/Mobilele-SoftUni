package softuni.mobilele.model.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {


//    private User user;

    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Model model;


    @Enumerated(EnumType.STRING)
    private EngineEnum engine;


    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmissionEnum;

    private String imageURL;



    private long mileage;

    private BigDecimal price;

    private int year;













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

    public TransmissionEnum transmission() {
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

    public UUID uuid() {
        return uuid;
    }

    public Offer setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }
}
