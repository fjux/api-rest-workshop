package se.lexicon.erikalfredsson.apiworkshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.data.BookRepository;
import se.lexicon.erikalfredsson.apiworkshop.data.LibraryUserRepository;
import se.lexicon.erikalfredsson.apiworkshop.data.LoanRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Transactional
class LoanTest {
    private LibraryUser userOne = new LibraryUser(LocalDate.now(), "Erik Alfredsson", "erik@erik.se");
    private LibraryUser userTwo = new LibraryUser(LocalDate.parse("2020-07-13"), "Fredrik Back", "fredde@bark.com");
    private LibraryUser userThree = new LibraryUser(LocalDate.parse("2007-12-01"), "Andreas Jansson", "Andy@gmail.com");
    private Book bookOne = new Book("Zen and the art of motorcycle maintenance", 30, BigDecimal.valueOf(5.0), "Written by Robert M Pirsig about a man and his son riding motorcycle with some friends. At the same time we are following the motorcyclists earlier life as a university professor structuring a system of quality under the alias of Phaedrus");
    private Book bookTwo = new Book("Thus Spoke Zarathustra", 30, BigDecimal.valueOf(5.0), "Written by Friedrich Nietzsche. Zarathustra, a 30-year-old sage and prophet, has retreated into the mountains. After 10 years of solitude, he emerges from his cave, wanting to descend to humanity in order to bestow his wisdom.");
    private Book bookThree = new Book("The Stand", 30, BigDecimal.valueOf(5.0), "The book revolves around a flu virus that is created by the American state. We get to meet people who try to live in a time of great crisis and survive with some sanity left");
    private Book bookFour = new Book("The Call of Cthulhu", 30, BigDecimal.valueOf(5.0), "Written by Howard Phillips Lovecraft. We get to follow some individuals that all get to witness parts of a mystery with extraterrestrial connotations. The first Person the reader gets to follow Francis Wayland Thurston and his investigations into some strange notes left behind by his great uncle.");
    private Book bookFive = new Book("The Blank slate", 30, BigDecimal.valueOf(5.0), "Written by Steven Pinker. Pinker argues that modern science has challenged three \"linked dogmas\" that constitute the dominant view of human nature in intellectual life: the blank slate (the mind has no innate traits)—empiricism, the noble savage (people are born good and corrupted by society)—romanticism, he ghost in the machine (each of us has a soul that makes choices free from biology)");
    private Loan loan1 = new Loan(userOne, bookOne, LocalDate.parse("2021-12-07"), false);
    private Loan loan2 = new Loan(userOne, bookTwo, LocalDate.parse("2022-01-02"), false);
    private Loan loan3 = new Loan(userTwo, bookThree, LocalDate.parse("2020-03-15"), true);
    private Loan loan4 = new Loan(userThree, bookFour, LocalDate.parse("2022-01-05"), false);
    private Loan loan5 = new Loan(userThree, bookFive, LocalDate.parse("2021-01-10"), true);

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LibraryUserRepository libraryUserRepository;
    @Autowired
    private BookRepository bookRepository;


    @BeforeEach
    void setUp() {

        userOne = libraryUserRepository.save(userOne);
        userTwo = libraryUserRepository.save(userTwo);
        userThree = libraryUserRepository.save(userThree);
        bookOne = bookRepository.save(bookOne);
        bookTwo = bookRepository.save(bookTwo);
        bookThree = bookRepository.save(bookThree);
        bookFour = bookRepository.save(bookFour);
        bookFive = bookRepository.save(bookFive);
        loan1 = loanRepository.save(loan1);
        loan2 = loanRepository.save(loan2);
        loan3 = loanRepository.save(loan3);
        loan4 = loanRepository.save(loan4);
        loan5 = loanRepository.save(loan5);
    }

    @Test
    void extendLoan() {
        bookOne.setReserved(true);
        bookRepository.save(bookOne);
        assertFalse(loan1.extendLoan());
        assertTrue(loan2.extendLoan());
    }

    @Test
    void isOverdue() {
        assertTrue(loan1.isOverdue());
    }

    @Test
    void getFine() {
        assertEquals(BigDecimal.valueOf(40), loan1.getFine());
    }


}