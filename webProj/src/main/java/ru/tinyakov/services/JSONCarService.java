/*
package ru.tinyakov.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinyakov.entity.Car;
import ru.tinyakov.exceptions.CarServicesException;
import ru.tinyakov.repository.JSONCarRepository;

import java.util.List;

@Component
public class JSONCarService implements ICarServices {

    @Autowired
    JSONCarRepository repository;

    public void setRepository(JSONCarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> get() throws CarServicesException {
        List<Car> list = repository.getAllCars();
        if (list == null) throw new CarServicesException("Empty list of the cars");

        return list;
    }

    @Override
    public Car get(int id) throws CarServicesException {
        Car c = repository.getCar(id);

        if(c == null)throw new CarServicesException("No car");

        return c;
    }

    @Override
    public boolean insert(Car car) throws CarServicesException {
        if(!repository.insert(car)) {
            throw new CarServicesException("Do not insert Car");
        }
        return true;
    }

    @Override
    public void delete(int id) throws CarServicesException {
        if(!repository.delete(id)) throw new CarServicesException("Car is not deleted");
    }

    @Override
    public void update(Car c) throws CarServicesException {
        if(!repository.update(c)) throw new CarServicesException("Car is not updated");
    }
}
*/
