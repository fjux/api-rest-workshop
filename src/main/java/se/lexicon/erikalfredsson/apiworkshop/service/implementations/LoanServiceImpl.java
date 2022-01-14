package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import se.lexicon.erikalfredsson.apiworkshop.model.dto.LoanDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LoanService;

import java.util.List;

public class LoanServiceImpl implements LoanService {
    @Override
    public LoanDTO create(LoanDTO dto) {
        return null;
    }

    @Override
    public LoanDTO findById(String s) {
        return null;
    }

    @Override
    public List<LoanDTO> findAll() {
        return null;
    }

    @Override
    public LoanDTO update(String s, LoanDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<LoanDTO> findByBookId(String bookId) {
        return null;
    }

    @Override
    public List<LoanDTO> findByUserId(String userId) {
        return null;
    }

    @Override
    public List<LoanDTO> findByEnded(boolean ended) {
        return null;
    }
}
