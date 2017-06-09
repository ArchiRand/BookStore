package by.bookStore.jdbc.dao;

import by.bookStore.jdbc.model.Book;
import by.bookStore.jdbc.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private int lastPage;
    private ConnectionUtil connectionUtil;

    public BookDaoImpl(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    @Override
    public boolean addBook(Book book) {
        String sql = "INSERT INTO book_store (title, author, price, description, published) " +
                "VALUES (?, ?, ?, ?, ?)";
        boolean isDone = false;
        try (Connection connection = connectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setString(4, book.getDescription());
            statement.setDate(5, book.getPublicationDate());
            isDone = statement.executeUpdate() > 0;
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDone;
    }

    @Override
    public Book getBookByID(int id) {
        String sql = "SELECT * FROM book_store WHERE id=?";
        Book book = null;
        try (Connection connection = connectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                book = new Book(
                        set.getInt("id"),
                        set.getString("title"),
                        set.getString("author"),
                        set.getDouble("price"),
                        set.getString("description"),
                        set.getDate("published"));
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Exception in getting method");
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(int page, int numberOfRows) {
        page = (page - 1) * numberOfRows;
        String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM book_store LIMIT " + page + ", " + numberOfRows;
        List<Book> list = new ArrayList<>();
        try (Connection connection = connectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            Book book;
            while (set.next()) {
                book = new Book(
                        set.getInt("id"),
                        set.getString("title"),
                        set.getString("author"),
                        set.getDouble("price"),
                        set.getString("description"),
                        set.getDate("published"));
                list.add(book);
            }
            set = statement.executeQuery("SELECT found_rows()");
            while (set.next()) {
                lastPage = (int)Math.ceil(set.getInt(1) * 1.0 / numberOfRows);
            }
        } catch (SQLException e) {
            System.out.println("Exception in getAll method");
        }
        return list;
    }

    @Override
    public boolean removeBook(int id) {
        String sql = "DELETE FROM book_store WHERE id=?";
        boolean isDone = false;
        try (Connection connection = connectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            isDone = statement.executeUpdate() > 0;
            statement.close();
        } catch (SQLException e) {
            System.out.println("Exception in remove method");
        }
        return isDone;
    }

    @Override
    public boolean updateBook(Book book) {
        String sql = "UPDATE book_store SET title=?, author=?, price=?, description=?, published=? WHERE id=?";
        boolean isDone = false;
        try (Connection connection = connectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(6, book.getId());
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setString(4, book.getDescription());
            statement.setDate(5, book.getPublicationDate());
            isDone = statement.executeUpdate() > 0;
            statement.close();
        } catch (SQLException e) {
            System.out.println("Exception in update method");
        }
        return isDone;
    }

    @Override
    public int getPages() {
        return lastPage;
    }
}
