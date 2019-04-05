package ru.tinyakov.services;

import ru.tinyakov.entity.Car;
import ru.tinyakov.exceptions.CarServicesException;

import java.util.List;

public interface ICarServices {
    List<Car> get();

    Car get(int id);

    void insert(Car car) throws CarServicesException;

    void delete(int id) throws CarServicesException;

    void update(Car car) throws CarServicesException;

}
