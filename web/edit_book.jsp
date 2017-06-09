<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditBook</title>
</head>
<body>
    <h1 align="center">${book.id == null ? "Добавляем книгу" : "Редактируем книгу"} </h1>
    <hr>
    <form method="post" action="book_store">
        <input type="hidden" value="${book.id}" name="id"/>
        <dl>
            <dt>Название</dt>
            <dl>
                <input type="text" name="title" value="${book.title}"/>
            </dl>
        </dl>
        <dl>
            <dt>Автор</dt>
            <dl>
                <input type="text" name="author" value="${book.author}"/>
            </dl>
        </dl>
        <dl>
            <dt>Стоимость</dt>
            <dl>
                <input type="number" name="price" value="${book.price}" step="0.01"/>
            </dl>
        </dl>
        <dl>
            <dt>Описание</dt>
            <dl>
                <input type="text" name="description" value="${book.description}"/>
            </dl>
        </dl>
        <dl>
            <dt>Издана</dt>
            <dl>
                <input type="date" name="date" value="${book.publicationDate}"/>
            </dl>
        </dl>
        <button type="submit">${book.id == null ? "Сохранить" : "Изменить"}</button>
    </form>
</body>
</html>
