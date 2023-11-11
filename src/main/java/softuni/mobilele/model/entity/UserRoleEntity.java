package softuni.mobilele.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.mobilele.model.enums.UserRoleEnum;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "user_roles")
public class UserRoleEntity extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;
}
