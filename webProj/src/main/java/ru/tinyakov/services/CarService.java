package ru.tinyakov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinyakov.entity.Car;
import ru.tinyakov.exceptions.CarServicesException;
import ru.tinyakov.repository.IRepository;

import java.util.List;

@Component
public class CarService implements ICarServices {

    @Autowired
    private IRepository<Car> repository;

    @Override
    public List<Car> get() {
        List<Car> list = repository.get();
        return list;
    }

    @Override
    public Car get(int id) {
        Car car = repository.get(id);
        return car;
    }

    @Override
    public void insert(Car car) throws CarServicesException {
        if (!repository.insert(car))
            throw new CarServicesException("Car don't insert");
    }

    @Override
    public void delete(int id) throws CarServicesException {
        if (!repository.delete(id))
            throw new CarServicesException("Car don't delete");
    }

    @Override
    public void update(Car car) throws CarServicesException {
        if (!repository.update(car))
            throw new CarServicesException("Car don't update");
    }
}
