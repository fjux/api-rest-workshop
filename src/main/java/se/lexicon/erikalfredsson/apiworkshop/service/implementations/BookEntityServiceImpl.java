package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.data.BookRepository;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.BookEntityService;

import java.util.List;

@Service
@Transactional
public class BookEntityServiceImpl implements BookEntityService {
    private final BookRepository bookRepository;

    public BookEntityServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findByReserved(boolean reserved) {
        return bookRepository.findAllByReservedEquals(reserved);
    }

    @Override
    public List<Book> findByAvailable(boolean available) {
        return bookRepository.findAllByAvailableEquals(available);
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findDistinctByTitleEquals(title);
    }

    @Override
    public Book create(BookDTO dto) {
        Book book = new Book(dto.getTitle(), dto.getMaxLoanDays(), dto.getFinePerDay(), dto.getDescription());
        return bookRepository.save(book);
    }

    @Override
    public Book findById(String bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " could not be found"));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(String bookId, BookDTO dto) {
        if (dto == null) throw new IllegalArgumentException("DTO was null");
        Book book = findById(bookId);
        book.setTitle(dto.getTitle());
        book.setAvailable(dto.isAvailable());
        book.setReserved(dto.isReserved());
        book.setMaxLoanDays(dto.getMaxLoanDays());
        book.setFinePerDay(dto.getFinePerDay());
        book.setDescription(dto.getDescription());
        return bookRepository.save(book);
    }

    @Override
    public boolean delete(String bookId) {
        bookRepository.deleteById(bookId);
        return !bookRepository.existsById(bookId);
    }
}
