<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookStore</title>
    <style>
        h1 {text-align: center;
        color: tan}
        .table_price {
            border-collapse: collapse;
            border-left: 3px solid #F79361;
            border-right: 3px solid #F79361;
            border-bottom: 3px solid #F79361;
            font-family: "Lucida Grande", sans-serif;
        }
        .table_price caption {
            background: #F79361;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            padding: 10px;
            box-shadow: 0 2px  4px 0 rgba(0,0,0,.3);
            color: white;
            font-family: "Roboto Slab",serif;
            font-style: normal;
            font-size: 26px;
            text-align: center;
            margin: 0;
        }
        .table_price td, .table_price th {
            padding: 10px;
        }
        .table_price th {
            text-align: left;
            font-size: 18px;
        }
        .table_price tr:nth-child(2n) {
            background: #E5E5E5;
        }
        .table_price td:last-of-type {
            text-align: center;
        }
        .table_price a {
            display: inline-block;
            padding: 5px 10px;
            background: #F79361;
            box-shadow: 2px 2px 0 0 #a22800;
            position: relative;
        }
        .table_price a:hover {
            text-decoration: underline;
            color: red;
            box-shadow: none;
            top: 2px;
            left: 2px;
        }
    </style>
</head>
<body>
<header>
    <h1>То, что я прочел или честно пытался</h1>
    <p>Отображать по
        <a href="book_store?number_of_rows=5"> 5</a>
        <a href="book_store?number_of_rows=10"> 10</a>
        <a href="book_store?number_of_rows=15"> 15</a>
        <a href="book_store?number_of_rows=20"> 20</a>
        записей.
    </p>
</header>
<hr>
<jsp:useBean id="timeUtil" class="by.bookStore.jdbc.util.timeUtil.TimeFormatter"/>
<p><a href="book_store?action=add">Добавить книгу</a></p>
<table class="table_price" align="center" width="100%">
    <caption>Must Read</caption>
    <thead>
        <tr>
            <th>Название</th>
            <th>Автор</th>
            <th>Описание</th>
            <th>Цена</th>
            <th>Первое издание</th>
            <th>Удалить</th>
            <th>Редактировать</th>
        </tr>
    </thead>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.description}</td>
            <td>${book.price}</td>
            <td>${timeUtil.fromDateToString(book.publicationDate)}</td>
            <td>
                <a href="book_store?action=delete&id=${book.id}">Удалить</a>
            </td>
            <td>
               <a href="book_store?action=edit&id=${book.id}">Изменить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <c:if test="${currentPage != 1}">
        <a href="book_store?page=${currentPage - 1}">Пред.</a>
    </c:if>

    <c:forEach var="i" begin="1" end="${lastPage}">
        <c:choose>
            <c:when test="${i eq currentPage}">
                ${i}
            </c:when>
            <c:otherwise>
                <a href="book_store?page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${currentPage != lastPage}">
        <a href="book_store?page=${currentPage + 1}">След.</a>
    </c:if>
</div>

</body>
</html>