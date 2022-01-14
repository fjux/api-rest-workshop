package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import se.lexicon.erikalfredsson.apiworkshop.model.Loan;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LoanDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LoanEntityService;

import java.util.List;

public class LoanEntityServiceImpl implements LoanEntityService {
    @Override
    public Loan create(LoanDTO dto) {
        return null;
    }

    @Override
    public Loan findById(String s) {
        return null;
    }

    @Override
    public List<Loan> findAll() {
        return null;
    }

    @Override
    public Loan update(String s, LoanDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Loan> findByBookId(String bookId) {
        return null;
    }

    @Override
    public List<Loan> findByUserId(String userId) {
        return null;
    }

    @Override
    public List<Loan> findByEnded(boolean ended) {
        return null;
    }
}
