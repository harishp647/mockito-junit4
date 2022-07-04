package com.harish.mockito.testDoublesannotations.support.exception_handling;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks()
    {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            //Log exception
            throw new DatabaseReadException("Unable to read from database due to -"+ e.getMessage());
//            e.printStackTrace();
        }
        int totalPrice = 0;

        for(Book book:books)
        {
            int price = book.getPrice();
            totalPrice = price+totalPrice;
        }
        return totalPrice;
    }

    public void addBook(com.harish.mockito.testDoublesannotations.support.annotations.Book book)
    {
        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            //e.printStackTrace();
            //We can log the exception and then throw our own customized exception  -> For that We created Database Write exception
            throw new DatabaseWriteException("Unable to write into Database due to - "+e.getMessage());
        }
    }

}
