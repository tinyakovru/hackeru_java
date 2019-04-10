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



    <h2>Список автомобилей в продаже</h2>
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
            <th>Марка</th>
            <th>Модель</th>
            <th>VIN</th>
            <th>Год выпуска</th>
            <th>Пробег</th>
            <th colspan="2">Operations</th>
        </tr>
        </thead>
        <tbody>

        <%
            List<Car> list = (List<Car>)request.getAttribute("cars");
            for (Car car : list) {
        %>

            <tr>
                <td><%=car.getId()%></td>
                <td><%=car.getMaker().getTitle()%></td>
                <td><%=car.getModel()%></td>
                <td><%=car.getVin()%></td>
                <td><%=car.getYear()%></td>
                <td><%=car.getOdometer()%></td>
                <td><a href="/cars/edit/<%=car.getId()%>">редактировать</a></td>
                <td><a href="/cars/delete/<%=car.getId()%>">удалить</a></td>
            </tr>
        <%
            }
        %>

        </tbody>
    </table>
    </c:otherwise>
    </c:choose>
</div>
</body>
</html>

