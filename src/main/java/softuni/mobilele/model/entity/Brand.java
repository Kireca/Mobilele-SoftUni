package softuni.mobilele.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;

    public String name() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }
}
