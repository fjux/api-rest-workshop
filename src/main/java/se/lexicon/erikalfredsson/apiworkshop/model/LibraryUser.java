package se.lexicon.erikalfredsson.apiworkshop.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

import static se.lexicon.erikalfredsson.apiworkshop.model.constants.EntityConstants.GENERATOR;
import static se.lexicon.erikalfredsson.apiworkshop.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class LibraryUser {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String userId;
    private LocalDate regDate;
    private String name;
    @Column( unique = true)
    private String email;

    public LibraryUser() {
    }

    public LibraryUser(LocalDate regDate, String name, String email) {
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
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
        if (!(o instanceof LibraryUser)) return false;
        LibraryUser that = (LibraryUser) o;
        return getUserId().equals(that.getUserId()) && Objects.equals(getRegDate(), that.getRegDate()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getRegDate(), getName(), getEmail());
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "userId='" + userId + '\'' +
                ", regDate=" + regDate +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
