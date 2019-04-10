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

    <title>Производители</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${maker.id == 0}">
            Создание нового производителя
        </c:when>
        <c:otherwise>
            Редактирование производителя <c:out value="${maker.title}"/>
        </c:otherwise>
    </c:choose>
    <div class="row" style="margin-top: 2em">
        <div class="col-6">
            <form:form modelAttribute="maker" method="POST" action="${action}">
                <form:hidden path="id"/>
                <div class="form-group">
                    <form:input class="form-control" path="title" placeholder="title"/>
                </div>
                <div class="form-group">
                    <input class="btn btn-primary" type="submit" value="Сохранить"/>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>

</html>
