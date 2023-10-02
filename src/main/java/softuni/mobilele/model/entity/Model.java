package softuni.mobilele.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.mobilele.model.enums.ModelCategoryEnum;


@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "models")
public class Model extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    private ModelCategoryEnum category;


    @ManyToOne
    private Brand brand;


}
