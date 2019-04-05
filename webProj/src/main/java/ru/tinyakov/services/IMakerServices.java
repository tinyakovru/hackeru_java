package ru.tinyakov.services;

import ru.tinyakov.entity.Car;
import ru.tinyakov.entity.Maker;
import ru.tinyakov.exceptions.CarServicesException;
import ru.tinyakov.exceptions.MakerServicesException;

import java.util.List;

public interface IMakerServices {
    List<Maker> get();

    Maker get(int id);

    void insert(Maker maker) throws MakerServicesException;

    void delete(int id) throws MakerServicesException;

    void update(Maker maker) throws MakerServicesException;

}
