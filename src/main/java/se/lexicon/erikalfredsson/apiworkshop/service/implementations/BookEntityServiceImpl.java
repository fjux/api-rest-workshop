package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import se.lexicon.erikalfredsson.apiworkshop.model.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.BookEntityService;

import java.util.List;

public class BookEntityServiceImpl implements BookEntityService {
    @Override
    public List<Book> findByReserved(boolean reserved) {
        return null;
    }

    @Override
    public List<Book> findByAvailable(boolean available) {
        return null;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }

    @Override
    public Book create(BookDTO dto) {
        return null;
    }

    @Override
    public Book findById(String s) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book update(String s, BookDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
