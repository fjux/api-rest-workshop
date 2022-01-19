package se.lexicon.erikalfredsson.apiworkshop.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

import static se.lexicon.erikalfredsson.apiworkshop.model.constants.EntityConstants.GENERATOR;
import static se.lexicon.erikalfredsson.apiworkshop.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class Book {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;

    public Book() {
    }

    public Book(String title, int maxLoanDays, BigDecimal finePerDay, String description) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.finePerDay = finePerDay;
        this.description = description;
        setAvailable(true);
        setReserved(false);
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean availableStatus) {
        this.available = availableStatus;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reservedStatus) {
        this.reserved = reservedStatus;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public BigDecimal getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay) {
        this.finePerDay = finePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isAvailable() == book.isAvailable() && isReserved() == book.isReserved() && getMaxLoanDays() == book.getMaxLoanDays() && getBookId().equals(book.getBookId()) && getTitle().equals(book.getTitle()) && Objects.equals(getFinePerDay(), book.getFinePerDay()) && Objects.equals(getDescription(), book.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getTitle(), isAvailable(), isReserved(), getMaxLoanDays(), getFinePerDay(), getDescription());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", reserved=" + reserved +
                ", maxLoanDays=" + maxLoanDays +
                ", finePerDay=" + finePerDay +
                ", description='" + description + '\'' +
                '}';
    }
}
