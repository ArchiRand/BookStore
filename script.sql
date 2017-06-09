DROP DATABASE IF EXISTS books;
CREATE DATABASE books;
USE books;
DROP TABLE IF EXISTS book_store;
CREATE TABLE book_store (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  title       VARCHAR(100) NOT NULL,
  author      VARCHAR(100) NOT NULL,
  price       DOUBLE       NOT NULL,
  description TEXT         NOT NULL,
  published   DATE         NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO book_store (title, author, price, description, published)
VALUES ('Thinking in Java (4th Edition)', 'Bruce Eckel', 45.68,
        'Thinking in Java should be read cover to cover by every Java programmer, then kept close at hand for frequent reference. The exercises are challenging, and the chapter on Collections is superb! Not only did this book help me to pass the Sun Certified Java Programmer exam; it’s also the first book I turn to whenever I have a Java question.',
        2006 - 01 - 01);
INSERT INTO book_store (title, author, price, description, published)
VALUES ('Effective Java (2nd Edition)', 'Joshua Bloch', 37.37,
        'Are you looking for a deeper understanding of the Java™ programming language so that you can write code that is clearer, more correct, more robust, and more reusable? Look no further! Effective Java™, Second Edition, brings together seventy-eight indispensable programmer’s rules of thumb: working, best-practice solutions for the programming challenges you encounter every day.',
        2008 - 05 - 01);
INSERT INTO book_store (title, author, price, description, published)
VALUES ('Head First Java, Second Edition', 'Kathy Sierra, Bert Bates', 44.95,
        'Head First Java delivers a highly interactive, multisensory learning experience that lets new programmers pick up the fundamentals of the Java language quickly. Through mind-stretching exercises, memorable analogies, humorous pictures, and casual language, Head First Java encourages readers to think like a Java programmer. This revised second edition focuses on Java 5.0, the latest version of the Java development platform.',
        2005 - 05 - 03);
INSERT INTO book_store (title, author, price, description, published)
VALUES ('Head First SQL', 'Lynn Beighley', 49.99,
        'Is your data dragging you down? Are your tables all tangled up? Well we''ve got the tools to teach you just how to wrangle your databases into submission. Using the latest research in neurobiology, cognitive science, and learning theory to craft a multi-sensory SQL learning experience, Head First SQL has a visually rich format designed for the way your brain works, not a text-heavy approach that puts you to sleep.',
        2007 - 08 - 08);
INSERT INTO book_store (title, author, price, description, published)
VALUES ('Head First Servlets and JSP, 2nd Edition', 'B Basham, K.Sierra, B.Bates', 49.99,
        'Learn how to write servlets and JSPs, what makes a web container tick (and what ticks it off), how to use JSP''s Expression Language (EL for short), and how to write deployment descriptors for your web applications. Master the c:out tag, and get a handle on exactly what''s changed since the older J2EE 1.4 exam. You don''t just pass the new J2EE 1.5 SCWCD exam, you''ll understand this stuff and put it to work immediately.',
        2008 - 03 - 05);
INSERT INTO book_store (title, author, price, description, published)
VALUES ('Core Java', 'Cay S. Horstmann', 26.90,
        'Core Java by Cay S. Horstmann and Gary Cornell was originally published in the Java series of Sun Microsystems Press and is now published by Prentice-Hall. The book is aimed at experienced programmers who want to learn how to write useful Java applications and applets. No hype, no toy code, no language lawyering, just solid facts and in-depth research to help you write real programs.',
        2015 - 12 - 24);
COMMIT;