package ru.tinyakov.repository;

import ru.tinyakov.entity.Car;

import java.util.List;

public interface ICarRepository {

    boolean insert(Car car);

    boolean insert(List<Car> cars);

    boolean delete (int id);

    boolean update(Car car);

    Car getCar(int id);

    List<Car> getAllCars();

}
