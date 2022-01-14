package se.lexicon.erikalfredsson.apiworkshop.model.dto;

import se.lexicon.erikalfredsson.apiworkshop.model.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.Loan;

import java.io.Serializable;
import java.time.LocalDate;

public class LoanDTO {
    private String loanId;
    private LibraryUserDTO loanTaker;
    private BookDTO book;
    private LocalDate loanDate;
    private boolean ended;

    public LoanDTO() {
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public LibraryUserDTO getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUserDTO loanTaker) {
        this.loanTaker = loanTaker;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
