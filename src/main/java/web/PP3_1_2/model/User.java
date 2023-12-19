package web.PP3_1_2.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userID;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be less than or equal to 50 characters")
    @Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only letters")
    @NotNull
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(max = 50, message = "Surname must be less than or equal to 50 characters")
    @Pattern(regexp = "[a-zA-Z]+", message = "Surname must contain only letters")
    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @NotNull
    @Column(name = "email")
    private String email;
    public User() {
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public long getId() {
        return userID;
    }

    public void setId(long id) {
        this.userID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, name, surname, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}