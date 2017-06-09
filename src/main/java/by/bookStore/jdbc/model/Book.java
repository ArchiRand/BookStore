package by.bookStore.jdbc.model;

import java.sql.Date;

public class Book {

    private Integer id;
    private String title;
    private String author;
    private String description;
    private double price;
    private Date publicationDate;

    public Book() {
    }

    public Book(String title, String author, double price, String description, Date publicationDate) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.publicationDate = publicationDate;
    }

    public Book(Integer id, String title, String author, double price, String description, Date publicationDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book - " +
                "author=" + author +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", publicationDate=" + publicationDate;
    }
}
