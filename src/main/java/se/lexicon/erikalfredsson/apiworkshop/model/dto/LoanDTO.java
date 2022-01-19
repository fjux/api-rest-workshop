package se.lexicon.erikalfredsson.apiworkshop.model.dto;

import java.time.LocalDate;

public class LoanDTO {
    private String loanId;
    private LibraryUserDTO loanTaker;
    private BookDTO bookDTO;
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

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
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
