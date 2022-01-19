package se.lexicon.erikalfredsson.apiworkshop.service;

import se.lexicon.erikalfredsson.apiworkshop.model.entity.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Loan;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LoanDTO;

public interface DTOService {
    BookDTO toFullBookDTO(Book book);
    LoanDTO toFullLoanDTO(Loan loan);
    LibraryUserDTO toFullLibraryUserDTO(LibraryUser libraryUser);
}
