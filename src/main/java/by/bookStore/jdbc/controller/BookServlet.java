package by.bookStore.jdbc.controller;

import by.bookStore.jdbc.dao.BookDao;
import by.bookStore.jdbc.dao.BookDaoImpl;
import by.bookStore.jdbc.model.Book;
import by.bookStore.jdbc.util.DriverManagerUtil;
import by.bookStore.jdbc.util.MySQLDataSourceUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class BookServlet extends HttpServlet {

    private BookDao bookDao = new BookDaoImpl(new MySQLDataSourceUtil());
    private int numberOfRows = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String rows = req.getParameter("number_of_rows");
        switch (action == null ? "list" : action) {
            case "list":
                String page = req.getParameter("page");
                int currentPage = 1;

                if (rows != null) {
                    numberOfRows = Integer.parseInt(rows);
                }
                if (page != null) {
                    currentPage = Integer.parseInt(page);
                }
                req.setAttribute("currentPage", currentPage);
                req.setAttribute("bookList", bookDao.getAllBooks(currentPage, numberOfRows));
                req.setAttribute("lastPage", bookDao.getPages());
                req.getRequestDispatcher("book_store.jsp").forward(req, resp);
                break;
            case "add":
                req.getRequestDispatcher("edit_book.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Book book = bookDao.getBookByID(id);
                req.setAttribute("book", book);
                req.getRequestDispatcher("edit_book.jsp").forward(req, resp);
                break;
            case "delete":
                id = Integer.parseInt(req.getParameter("id"));
                bookDao.removeBook(id);
                resp.sendRedirect("book_store");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String bookId = req.getParameter("id");

        if (bookId.length() == 0) {
            bookDao.addBook(createBook(req, null));
        } else {
            Book book = bookDao.getBookByID(Integer.parseInt(bookId));
            bookDao.updateBook(createBook(req, book));
        }
        resp.sendRedirect("book_store");
    }

     private Book createBook(HttpServletRequest req, Book book) {
        if (book == null) {
            book = new Book();
        }
        book.setTitle(req.getParameter("title"));
        book.setAuthor(req.getParameter("author"));
        book.setPrice(Double.parseDouble(req.getParameter("price")));
        book.setDescription(req.getParameter("description"));
        book.setPublicationDate(Date.valueOf(req.getParameter("date")));
        return book;
     }
}
