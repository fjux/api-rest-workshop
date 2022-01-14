package se.lexicon.erikalfredsson.apiworkshop.service.interfaces;

import se.lexicon.erikalfredsson.apiworkshop.model.dto.LoanDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.GenericCRUD;

import java.util.List;

public interface LoanService extends GenericCRUD<LoanDTO, LoanDTO, String> {
    List<LoanDTO> findByBookId(String bookId);
    List<LoanDTO> findByUserId(String userId);
    List<LoanDTO> findByEnded(boolean ended);
}
