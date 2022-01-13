package se.lexicon.erikalfredsson.apiworkshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.erikalfredsson.apiworkshop.model.Book;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findDistinctByTitleEquals(String title);
    List<Book> findAllByAvailableEquals(boolean status);
    List<Book> findAllByReservedEquals(boolean status);
}
