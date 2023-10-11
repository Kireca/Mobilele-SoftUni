package softuni.mobilele.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "brands")
@NamedEntityGraph(
        name = "brandWithModels",
        attributeNodes = @NamedAttributeNode("models")
)
public class Brand extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "brand")
    private List<Model> models;


}
