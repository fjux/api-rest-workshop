package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<BookDTO> findByReserved(boolean reserved) {
        return null;
    }

    @Override
    public List<BookDTO> findByAvailable(boolean available) {
        return null;
    }

    @Override
    public List<BookDTO> findByTitle(String title) {
        return null;
    }

    @Override
    public BookDTO create(BookDTO dto) {
        return null;
    }

    @Override
    public BookDTO findById(String s) {
        return null;
    }

    @Override
    public List<BookDTO> findAll() {
        return null;
    }

    @Override
    public BookDTO update(String s, BookDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
