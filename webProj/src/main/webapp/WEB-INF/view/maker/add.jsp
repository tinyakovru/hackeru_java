<%-- 
    Document   : add
    Created on : 27.03.2019, 14:03:19
    Author     : admin
--%>

<%@page import="ru.tinyakov.entity.Car"%>
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
            Car car = (Car) request.getAttribute("car");
            if (car.getId() != 0){
            %>
            <h2>Редактируем Авто <%=car.getId()+" "+car.getMaker() + " " + car.getModel()+" "+car.getVin()%></h2>
            <%} else { %>
            <h2>Создаем новый автомобиль</h2>
            <%}%>
            <div class="row">
                <div class="col-6">
                    <form method="POST" action="/maker/insert">
                        <input type="hidden" name="id" value="<%=car.getId()%>" />
                        <div class="form-group">
                            <input class="form-control" type="text" name="maker" placeholder="производитель" value="<%=car.getMaker()!=null?car.getMaker(): ""%>" />
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
</html>
