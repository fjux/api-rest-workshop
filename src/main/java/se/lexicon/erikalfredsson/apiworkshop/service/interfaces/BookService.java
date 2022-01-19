package se.lexicon.erikalfredsson.apiworkshop.service.interfaces;

import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;

import java.util.List;

public interface BookService extends GenericCRUD<BookDTO, BookDTO, String> {
List<BookDTO> findByReserved(boolean reserved);
List<BookDTO> findByAvailable(boolean available);
BookDTO findByTitle(String title);
}
