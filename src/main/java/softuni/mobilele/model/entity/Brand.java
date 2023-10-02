package softuni.mobilele.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;


}
