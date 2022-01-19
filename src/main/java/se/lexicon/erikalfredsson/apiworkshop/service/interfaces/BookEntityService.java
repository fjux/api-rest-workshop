package se.lexicon.erikalfredsson.apiworkshop.service.interfaces;

import se.lexicon.erikalfredsson.apiworkshop.model.entity.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;

import java.util.List;

public interface BookEntityService extends GenericCRUD<Book, BookDTO, String>{
    List<Book> findByReserved(boolean reserved);
    List<Book> findByAvailable(boolean available);
    Book findByTitle(String title);
}
