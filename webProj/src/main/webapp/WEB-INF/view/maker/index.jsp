<%--
    Document   : index.jsp
    Created on : 26.03.2019, 15:53:23
    Author     : admin
--%>

<%@page import="ru.tinyakov.entity.Maker"%>
<%@page import="java.util.List"%>
<%@ page import="ru.tinyakov.entity.Maker" %>
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
    <h2>Список автопроизводителей</h2>
    <hr />
    <div style="margin-bottom: 2em" class="row">
        <div class="col-12">
            <a href="/maker/add" class="btn btn-primary">Добавить производителя</a>
        </div>
    </div>
    <table class="table table-hovered table-border">
        <thead>
        <tr>
            <th>ID</th>
            <th>Производитель</th>

            <th colspan="2">Operations</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Maker> list = (List<Maker>)request.getAttribute("maker");
            for (Maker m : list) {
        %>
        <tr>
            <td><%=m.getId()%></td>
            <td><%=m.getTitle()%></td>

            <td><a href="/cars/edit/<%=m.getId()%>">edit</a></td>
            <td><a href="/cars/delete/<%=m.getId()%>">delete</a></td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
</div>
</body>
</html>
