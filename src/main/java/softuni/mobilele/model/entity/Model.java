package softuni.mobilele.model.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import softuni.mobilele.model.enums.ModelCategoryEnum;


@NoArgsConstructor

@Entity
@Table(name = "models")
public class Model extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    private ModelCategoryEnum category;


    @ManyToOne
    private Brand brand;


    public String name() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategoryEnum category() {
        return category;
    }

    public Model setCategory(ModelCategoryEnum category) {
        this.category = category;
        return this;
    }

    public Brand brand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
