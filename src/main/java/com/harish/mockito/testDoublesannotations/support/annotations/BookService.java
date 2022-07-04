package com.harish.mockito.testDoublesannotations.support.annotations;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   public List<Book> booksWithApplieddiscount(int discountRate, int days)
    {
        List<Book> newBooks = bookRepository.findnewBooks(days);
        for(Book book : newBooks)
        {
            int price = book.getPrice();
            int newPrice = price - (price*discountRate/100);
            book.setPrice(newPrice);
        }
        return newBooks;
    }
}
