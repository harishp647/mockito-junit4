package com.harish.mockito.testDoublesannotations.support.stubbing;

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

    public int calculateTotalCost(List<Integer> bookIds)
    {
        int totalCost = 0;
        for(Integer bookId:bookIds)
        {
            Book book = bookRepository.findBookByBookId(bookId);
            totalCost = book.getPrice()+totalCost;
        }
        return totalCost;
    }

    public void addBook(Book book)
    {
        bookRepository.saveBook(book);
    }

    public void addBook(BookRequest bookRequest)
    {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.saveBook(book);
    }
}
