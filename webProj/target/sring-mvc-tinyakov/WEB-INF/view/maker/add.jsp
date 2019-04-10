<%-- 
    Document   : add
    Created on : 27.03.2019, 14:03:19
    Author     : admin
--%>

<%@ page import="ru.tinyakov.entity.Maker" %>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <% 
            Maker maker = (Maker) request.getAttribute("maker");
            if (maker.getId() != 0){
            %>
            <h2>Редактируем производителя <%=maker.getId()%></h2>
            <%} else { %>
            <h2>Добавляем нового производителя</h2>
            <%}%>
            <div class="row">
                <div class="col-6">
                    <form method="POST" action="/maker/insert">
                        <input type="hidden" name="id" value="<%=maker.getId()%>" />
                        <div class="form-group">
                            <input class="form-control" type="text" name="title" placeholder="title"
                                   value="<%=maker.getTitle()!=null?maker.getTitle(): ""%>" />
                        </div>


                        <div class="form-group">
                            <input class="btn btn-primary" type="submit" value="Save" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
