package se.lexicon.erikalfredsson.apiworkshop.service.interfaces;

import se.lexicon.erikalfredsson.apiworkshop.model.entity.Loan;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LoanDTO;

import java.util.List;

public interface LoanEntityService extends GenericCRUD<Loan, LoanDTO, String>{
        List<Loan> findByBookId(String bookId);
        List<Loan> findByUserId(String userId);
        List<Loan> findByEnded(boolean ended);
}
