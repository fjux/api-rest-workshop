package se.lexicon.erikalfredsson.apiworkshop.service.interfaces;

import se.lexicon.erikalfredsson.apiworkshop.model.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;

import java.util.List;

public interface BookEntityService extends GenericCRUD<Book, BookDTO, String>{
    List<Book> findByReserved(boolean reserved);
    List<Book> findByAvailable(boolean available);
    List<Book> findByTitle(String title);
}
