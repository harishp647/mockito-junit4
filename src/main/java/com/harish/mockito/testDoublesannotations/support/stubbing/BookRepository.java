package com.harish.mockito.testDoublesannotations.support.stubbing;

import java.util.List;

public interface BookRepository {


    void saveBook(Book book);

    List<Book> findnewBooks(int days);

    Book findBookByBookId(Integer bookId);
}
