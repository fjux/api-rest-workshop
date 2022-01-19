package se.lexicon.erikalfredsson.apiworkshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Book findDistinctByTitleEquals(String title);
    List<Book> findAllByAvailableEquals(boolean status);
    List<Book> findAllByReservedEquals(boolean status);
}
