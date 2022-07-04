package com.harish.mockito.testDoublesannotations.support.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks() throws SQLException;
    void save(com.harish.mockito.testDoublesannotations.support.annotations.Book book) throws SQLException;
}
