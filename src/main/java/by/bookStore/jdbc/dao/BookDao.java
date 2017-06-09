package by.bookStore.jdbc.dao;

import by.bookStore.jdbc.model.Book;

import java.util.List;

public interface BookDao {
    boolean addBook(Book book);
    Book getBookByID(int id);
    List<Book> getAllBooks(int page, int numberOfRows);
    boolean removeBook(int id);
    boolean updateBook(Book book);
    int getPages();
}
