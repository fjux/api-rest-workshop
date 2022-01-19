package se.lexicon.erikalfredsson.apiworkshop.model.dto;

import java.time.LocalDate;

public class LibraryUserDTO {
    private String userId;
    private LocalDate regDate;
    private String name;
    private String email;

    public LibraryUserDTO() {
    }

    public LibraryUserDTO(LocalDate regDate, String name, String email) {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
