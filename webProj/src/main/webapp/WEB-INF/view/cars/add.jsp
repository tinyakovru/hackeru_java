<%-- 
    Document   : add
    Created on : 27.03.2019, 14:03:19
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />

    <title>Автомобили</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${car.id == 0}">
            Создание нового автомобиля
        </c:when>
        <c:otherwise>
            Редактирование автомобиля<c:out value="${car.model}"/>
        </c:otherwise>
    </c:choose>
    <div class="row" style="margin-top: 2em">
        <div class="col-6">
            <form:form modelAttribute="car" method="POST" action="${action}">
                <form:hidden path="id"/>
                <div class="form-group">
                    <form:select class="form-control" path="maker" itemLabel="title" itemValue="id" items="${makers}"/>
                </div>
                <div class="form-group">
                    <form:input class="form-control" path="model" placeholder="Модель"/>
                </div>
                <div class="form-group">
                    <form:input class="form-control" path="vin" placeholder="vin"/>
                </div>
                <div class="form-group">
                    <form:input class="form-control" path="year" placeholder="год"/>
                </div>
                <div class="form-group">
                    <form:input class="form-control" path="odometer" placeholder="пробег"/>
                </div>

                <div class="form-group">
                    <input class="btn btn-primary" type="submit" value="Сохранить"/>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
<%--
<body>
    <div class="container">
        <%
        Car car = (Car) request.getAttribute("car");
        if (car.getId() != 0){
        %>
        <h2>Редактируем Авто <%=car.getId()+" "+car.getMaker() + " " + car.getModel()+" "+car.getVin()%></h2>
        <%} else { %>
        <h2>Создаем новый автомобиль</h2>
        <%}%>
        <div class="row">
            <div class="col-6">
                <form method="POST" action="${action}">
                    <input type="hidden" name="id" value="<%=car.getId()%>" />
                    <div class="form-group">
                        <form:select class="form-control" path="maker" itemLabel="name" itemValue="id" items="${makers}"  />
                    </div>

                    <div class="form-group">
                        <input class="form-control" type="text" name="model" placeholder="модель" value="<%=car.getModel()!=null?car.getModel(): ""%>" />
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="text" name="vin" placeholder="VIN" value="<%=car.getVin()!=null?car.getVin(): ""%>" />
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="text" name="year" placeholder="год выпуска" value="<%=(Integer)(car.getYear())!=null?car.getYear(): ""%>" />
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="text" name="odometer" placeholder="пробег" value="<%=(Integer)(car.getOdometer())!=null?car.getOdometer(): ""%>" />
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Save" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
--%>
</html>
