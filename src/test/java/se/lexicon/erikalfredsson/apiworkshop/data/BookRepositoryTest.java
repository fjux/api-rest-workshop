package se.lexicon.erikalfredsson.apiworkshop.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Book;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.Loan;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
class BookRepositoryTest {

    private LibraryUser userOne = new LibraryUser(LocalDate.now(), "Erik Alfredsson", "erik@erik.se");
    private LibraryUser userTwo = new LibraryUser(LocalDate.parse("2020-07-13"), "Fredrik Back", "fredde@bark.com");
    private LibraryUser userThree = new LibraryUser(LocalDate.parse("2007-12-01"), "Andreas Jansson", "Andy@gmail.com");
    private Book bookOne = new Book("Zen and the art of motorcycle maintenance", 30, BigDecimal.valueOf(5.0), "Written by Robert M Pirsig about a man and his son riding motorcycle with some friends. At the same time we are following the motorcyclists earlier life as a university professor structuring a system of quality under the alias of Phaedrus");
    private Book bookTwo = new Book("Thus Spoke Zarathustra", 30, BigDecimal.valueOf(5.0), "Written by Friedrich Nietzsche. Zarathustra, a 30-year-old sage and prophet, has retreated into the mountains. After 10 years of solitude, he emerges from his cave, wanting to descend to humanity in order to bestow his wisdom.");
    private Book bookThree = new Book("The Stand", 30, BigDecimal.valueOf(5.0), "The book revolves around a flu virus that is created by the American state. We get to meet people who try to live in a time of great crisis and survive with some sanity left");
    private Book bookFour = new Book("The Call of Cthulhu", 30, BigDecimal.valueOf(5.0), "Written by Howard Phillips Lovecraft. We get to follow some individuals that all get to witness parts of a mystery with extraterrestrial connotations.");
    private Book bookFive = new Book("The Blank slate", 30, BigDecimal.valueOf(5.0), "Written by Steven Pinker. Pinker argues that modern science has challenged three \"linked dogmas\" that constitute the dominant view of human nature in intellectual life.");
    private Loan loan1 = new Loan(userOne, bookOne, LocalDate.parse("2021-12-07"));
    private Loan loan2 = new Loan(userOne, bookTwo, LocalDate.parse("2022-01-02"));
    private Loan loan3 = new Loan(userTwo, bookThree, LocalDate.parse("2020-03-15"));
    private Loan loan4 = new Loan(userThree, bookFour, LocalDate.parse("2022-01-05"));
    private Loan loan5 = new Loan(userThree, bookFive, LocalDate.parse("2021-01-10"));

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LibraryUserRepository libraryUserRepository;
    @Autowired
    private BookRepository testObject;


    @BeforeEach
    void setUp() {
        userOne = libraryUserRepository.save(userOne);
        userTwo = libraryUserRepository.save(userTwo);
        userThree = libraryUserRepository.save(userThree);
        bookOne = testObject.save(bookOne);
        bookTwo = testObject.save(bookTwo);
        bookThree = testObject.save(bookThree);
        bookFour = testObject.save(bookFour);
        bookFive = testObject.save(bookFive);
        loan1 = loanRepository.save(loan1);
        loan2 = loanRepository.save(loan2);
        loan3 = loanRepository.save(loan3);
        loan4 = loanRepository.save(loan4);
        loan5 = loanRepository.save(loan5);
    }

    @Test
    void findDistinctByTitleEquals() {
        System.out.println(testObject.findDistinctByTitleEquals("The Blank slate"));
        assertNotNull(testObject.findDistinctByTitleEquals(bookFive.getTitle()));
    }

    @Test
    void findAllByAvailableEquals() {
        assertEquals(2, testObject.findAllByAvailableEquals(true).size());
        assertEquals(3, testObject.findAllByAvailableEquals(false).size());
    }

    @Test
    void findAllByReservedEquals() {
        bookOne.setReserved(true);
        bookFour.setReserved(true);
        assertEquals(2, testObject.findAllByReservedEquals(true).size());
        assertEquals(3, testObject.findAllByReservedEquals(false).size());
    }
}