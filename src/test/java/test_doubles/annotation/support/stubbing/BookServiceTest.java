package test_doubles.annotation.support.stubbing;

import com.harish.mockito.testDoublesannotations.support.stubbing.Book;
import com.harish.mockito.testDoublesannotations.support.stubbing.BookRepository;
import com.harish.mockito.testDoublesannotations.support.stubbing.BookRequest;
import com.harish.mockito.testDoublesannotations.support.stubbing.BookService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void stubbingTest()
    {
        List<Integer> bookIds = new ArrayList<>();
        bookIds.add(1234);
        bookIds.add(12345);

        Book book1 = new Book(1234, "MockitoInAction", 500, LocalDate.now());
        Book book2 = new Book(12345, "JUnit5InAction", 400, LocalDate.now());

//        when(bookRepository.findBookByBookId(12345)).thenReturn(book2);
//        when(bookRepository.findBookByBookId(1234)).thenReturn(book1);

        doReturn(book2).when(bookRepository).findBookByBookId(12345);
        doReturn(book1).when(bookRepository).findBookByBookId(1234);

        int actualcost = bookService.calculateTotalCost(bookIds);

        assertEquals(900,actualcost);
    }

    @Test
    public void testSaveBook()
    {
        Book book1 = new Book(null, "MockitoInAction", 500, LocalDate.now());

        doNothing().when(bookRepository).saveBook(book1);
        bookService.addBook(book1);
    }

    @Test
    public void testSaveBookWithBookRequest()
    {
      BookRequest bookRequest = new BookRequest("MockitoInAction", 500, LocalDate.now());
        Book book1 = new Book(null, "MockitoInAction", 500, LocalDate.now());

        doNothing().when(bookRepository).saveBook(book1);
      bookService.addBook(bookRequest);
    }
}
