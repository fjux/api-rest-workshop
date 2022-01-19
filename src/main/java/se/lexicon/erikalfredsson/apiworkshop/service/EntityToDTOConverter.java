package se.lexicon.erikalfredsson.apiworkshop.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Loan;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LoanDTO;

@Component
@Transactional
public class EntityToDTOConverter implements DTOService {
    @Override
    public BookDTO toFullBookDTO(Book book) {
        if (book == null) return null;
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setTitle(bookDTO.getTitle());
        bookDTO.setAvailable(true);
        bookDTO.setReserved(false);
        bookDTO.setMaxLoanDays(book.getMaxLoanDays());
        bookDTO.setFinePerDay(book.getFinePerDay());
        bookDTO.setDescription(book.getDescription());
        return bookDTO;
    }

    @Override
    public LoanDTO toFullLoanDTO(Loan loan) {
        if (loan == null) return null;
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setLoanId(loan.getLoanId());
        loanDTO.setLoanTaker(toFullLibraryUserDTO(loan.getLoanTaker()));
        loanDTO.setBookDTO(toFullBookDTO(loan.getBook()));
        loanDTO.setLoanDate(loan.getLoanDate());
        loanDTO.setEnded(loan.isEnded());
        return loanDTO;
    }

    @Override
    public LibraryUserDTO toFullLibraryUserDTO(LibraryUser libraryUser) {
        if (libraryUser == null) return null;
        LibraryUserDTO libraryUserDTO = new LibraryUserDTO();
        libraryUserDTO.setUserId(libraryUser.getUserId());
        libraryUserDTO.setRegDate(libraryUser.getRegDate());
        libraryUserDTO.setName(libraryUser.getName());
        libraryUserDTO.setEmail(libraryUser.getEmail());
        return libraryUserDTO;
    }
}
