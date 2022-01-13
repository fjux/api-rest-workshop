package se.lexicon.erikalfredsson.apiworkshop.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static se.lexicon.erikalfredsson.apiworkshop.model.constants.EntityConstants.GENERATOR;
import static se.lexicon.erikalfredsson.apiworkshop.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
@Table(name = "book_loan")
public class Loan {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String loanId;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_userid")
    private LibraryUser loanTaker;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_book_id")
    private Book book;
    private LocalDate loanDate;
    private boolean ended;

    public Loan() {
    }

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean ended) {
        this.loanTaker = loanTaker;
        if (book.isAvailable()){
            this.book = book;
            this.loanDate = loanDate;
            this.ended = ended;
        } else {
            throw new IllegalArgumentException("The book " + book.getTitle() + " is not available");
        }


    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public String getLoanId() {
        return loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return isEnded() == loan.isEnded() && loanId.equals(loan.loanId) && getLoanTaker().equals(loan.getLoanTaker()) && getBook().equals(loan.getBook()) && loanDate.equals(loan.loanDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, getLoanTaker(), getBook(), loanDate, isEnded());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", ended=" + ended +
                '}';
    }

    public boolean isOverdue() {
        LocalDate dueDate = loanDate.plusDays(30);
        LocalDate extendedDate = loanDate.plusDays(60);
        LocalDate now = LocalDate.now();
        if (now.isAfter(dueDate) && !extendLoan()){

            return true;
        } else if (extendLoan() && now.isAfter(extendedDate)){
            return true;
        }
        return false;
    }

    public BigDecimal getFine(){
        LocalDate dueDate = loanDate.plusDays(30);
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(dueDate, today);
        BigDecimal fine = book.getFinePerDay();
        BigDecimal days = BigDecimal.valueOf(daysBetween);
        BigDecimal amountToPay;
        if (isOverdue()) {
            amountToPay = fine.multiply(days);
            return amountToPay;
        }
        return BigDecimal.valueOf(0);
    }

    public boolean extendLoan(){
        if (!getBook().isReserved()) {
            return true;
        }
        return false;
    }


}
