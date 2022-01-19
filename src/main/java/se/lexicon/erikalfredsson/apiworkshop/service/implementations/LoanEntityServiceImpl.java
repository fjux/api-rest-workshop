package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.data.LoanRepository;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Loan;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LoanDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.BookEntityService;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LibraryUserEntityService;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LoanEntityService;

import java.time.LocalDate;
import java.util.List;
@Service
@Transactional
public class LoanEntityServiceImpl implements LoanEntityService {
    private final LoanRepository loanRepository;
    private final BookEntityService bookEntityService;
    private final LibraryUserEntityService libraryUserEntityService;

    public LoanEntityServiceImpl(LoanRepository loanRepository, BookEntityService bookEntityService, LibraryUserEntityService libraryUserEntityService) {
        this.loanRepository = loanRepository;
        this.bookEntityService = bookEntityService;
        this.libraryUserEntityService = libraryUserEntityService;

    }

    @Override
    public Loan create(LoanDTO dto) {
        if (dto == null) throw new IllegalArgumentException("DTO was null");
        if (dto.getLoanTaker() == null || dto.getBookDTO() == null) {
            throw new IllegalArgumentException("dto.loanTaker or dto.libraryBook was null");
        }
        Book book = bookEntityService.findById(dto.getBookDTO().getBookId());
        LibraryUser libraryUser = libraryUserEntityService.findById(dto.getLoanTaker().getUserId());
        if (book.isAvailable()) {
            Loan loan = new Loan();
            loan.setLoanTaker(libraryUser);
            loan.setBook(book);
            loan.setLoanDate(LocalDate.now());
            loan.setEnded(false);
            return loanRepository.save(loan);
        } else {
            throw new IllegalStateException("Book is not available");
        }
    }

    @Override
    public Loan findById(String loanId) {
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan wit id " + loanId + " could not be found"));
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan update(String loanId, LoanDTO dto) {
        if (dto == null) throw new IllegalArgumentException("DTO was null");
        Loan loan = findById(loanId);
        loan.setLoanTaker(libraryUserEntityService.findById(dto.getLoanTaker().getUserId()));
        loan.setBook(bookEntityService.findById(dto.getBookDTO().getBookId()));
        loan.setEnded(dto.isEnded());
        loan.setLoanDate(dto.getLoanDate());

        return loanRepository.save(loan);
    }

    @Override
    public boolean delete(String loanId) {
        loanRepository.deleteById(loanId);
        return !loanRepository.existsById(loanId);
    }

    @Override
    public List<Loan> findByBookId(String bookId) {
        return loanRepository.findAllByBookId(bookId);
    }

    @Override
    public List<Loan> findByUserId(String userId) {
        return loanRepository.findAllByUserId(userId);
    }

    @Override
    public List<Loan> findByEnded(boolean ended) {
        return loanRepository.findAllByEndedEquals(ended);
    }
}
