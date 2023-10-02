package softuni.mobilele.model.entity;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private long mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int year;

}
