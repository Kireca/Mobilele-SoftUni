package softuni.mobilele.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
public class User extends BaseEntity {

    @Column(unique = true)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private boolean active;

    public String email() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }
}