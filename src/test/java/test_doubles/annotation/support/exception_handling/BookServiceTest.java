package test_doubles.annotation.support.exception_handling;


import com.harish.mockito.testDoublesannotations.support.annotations.Book;
import com.harish.mockito.testDoublesannotations.support.exception_handling.BookRepository;
import com.harish.mockito.testDoublesannotations.support.exception_handling.BookService;
import com.harish.mockito.testDoublesannotations.support.exception_handling.DatabaseReadException;
import com.harish.mockito.testDoublesannotations.support.exception_handling.DatabaseWriteException;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testTotalPriceOfBooks() throws SQLException {
        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        assertThrows(DatabaseReadException.class,() -> bookService.getTotalPriceOfBooks());
      //int totalPriceOfBooks = bookService.getTotalPriceOfBooks();
    }

    @Test
    public void testAddBooks() throws SQLException {
        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        // 1. When we are dealing with void methods, we cant use when then throw
        //2. when we call when method, It provide name of the method - It returns ongoing stubing of a particular type, for void methods
        //The above wont work, there is a different way to tell mockito that this is a void method and throw an exception
        // 2Here  findAllBooks has some return type, In our Book repositort we create a new void method to save a book
        assertThrows(DatabaseReadException.class,() -> bookService.getTotalPriceOfBooks());
        //int totalPriceOfBooks = bookService.getTotalPriceOfBooks();
    }

    @Test
    public void testSaveBooks() throws SQLException {
        Book book = new Book(1234, "MockitoInAction", 500, LocalDate.now());
        //when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        doThrow(SQLException.class).when(bookRepository).save(book);
        assertThrows(DatabaseWriteException.class,() -> bookService.addBook(book));
        // 1. When we are dealing with void methods, we cant use when then throw
        //2. when we call when method, It provide name of the method - It returns ongoing stubing of a particular type, for void methods
        //The above wont work, there is a different way to tell mockito that this is a void method and throw an exception
        // 2Here  findAllBooks has some return type, In our Book repositort we create a new void method to save a book

        //int totalPriceOfBooks = bookService.getTotalPriceOfBooks();
    }

}
