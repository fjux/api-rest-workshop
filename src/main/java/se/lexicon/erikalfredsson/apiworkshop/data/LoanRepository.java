package se.lexicon.erikalfredsson.apiworkshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Loan;

import java.util.List;
@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {
    @Query("SELECT l FROM Loan l WHERE l.loanTaker.userId =:id")
    List<Loan> findAllByUserId(@Param("id") String id);
    @Query("SELECT l FROM Loan l WHERE l.book.bookId =:id")
    List<Loan> findAllByBookId(@Param("id") String id);
    List<Loan> findAllByEndedEquals(boolean ended);
}
