<%--
    Document   : index.jsp
    Created on : 26.03.2019, 15:53:23
    Author     : admin
--%>

<%@page import="ru.tinyakov.entity.Car"%>
<%@page import="java.util.List"%>
<%@ page import="ru.tinyakov.entity.Car" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    <title>Автомобили</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${success == false}">
            <div class="bg-error">Ошибка: ${message}</div>
        </c:when>
        <c:otherwise>
            <h2>Список автомобилей</h2>
            <hr />
            <div style="margin-bottom: 2em" class="row">
                <div class="col-12">
                    <a href="/cars/add" class="btn btn-primary">Добавить автомобиль</a>
                </div>
            </div>
            <table class="table table-hovered table-border">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Производитель</th>
                    <th>Модель</th>
                    <th>VIN</th>
                    <th>год</th>
                    <th>пробег</th>
                    <th colspan="2">Операции</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.maker.title}</td>
                        <td>${car.model}</td>
                        <td>${car.vin}</td>
                        <td>${car.year}</td>
                        <td>${car.odometer}</td>
                        <td><a href="/cars/edit/${car.id}">редактировать</a></td>
                        <td><a href="/cars/delete/${car.id}">удалить</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>

