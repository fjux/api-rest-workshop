package se.lexicon.erikalfredsson.apiworkshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.LibraryUser;

@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUser, String> {
    LibraryUser findDistinctByEmailEquals(String email);

}
