package ru.tinyakov.services;

import ru.tinyakov.entity.Car;
import ru.tinyakov.exceptions.CarServicesException;

import java.util.List;

public interface ICarServices {
    List<Car> get() throws CarServicesException;

    Car get(int id) throws CarServicesException;

    void delete(int id) throws CarServicesException;

    void update(Car address) throws CarServicesException;

}
