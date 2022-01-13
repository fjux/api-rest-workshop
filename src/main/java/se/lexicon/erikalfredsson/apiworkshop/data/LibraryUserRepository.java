package se.lexicon.erikalfredsson.apiworkshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.erikalfredsson.apiworkshop.model.LibraryUser;

import java.util.Optional;
@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUser, String> {
    Optional<LibraryUser> findDistinctByEmailEquals(String email);

}
