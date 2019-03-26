package ru.tinyakov.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;
import ru.tinyakov.entity.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class JSONCarRepository implements ICarRepository {

    private File file = null;
    private ObjectMapper mapper;

    {
        try {
            file = ResourceUtils.getFile("classpath:cars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setMapper(ObjectMapper mafind pper) {
        this.mapper = mapper;
    }

    @Override
    public boolean insert(Car car) {
        return false;
    }

    @Override
    public boolean insert(List<Car> cars) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        List<Car> list = getAllCars();
        int deleted = 0;
        if (list !=null){
            try {
                //Удаляем
                for (Car delCar: list) {
                    if (delCar.getId() == id){
                        list.remove(delCar);
                        deleted++;
                        break;
                    }
                }
                if (deleted > 0){
                    //Чистим файл
                    mapper.writeValue(file,new String());
                    //Пишем в файл
                    mapper.writeValue(file, list);
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(Car car) {
        List<Car> list = null;
        try {
            list = mapper.readValue(file, new TypeReference<List<Car>>(){});
            if (list != null) {
                list.stream()
                        .filter(c -> c.getId() == car.getId())
                        .forEach(c -> {
                            c.setMaker(car.getMaker());
                            c.setModel(car.getVin());
                            c.setOdometer(car.getOdometer());
                            c.setVin(car.getVin());
                            c.setYear(car.getYear());
                        });
                mapper.writeValue(file, new String());
                mapper.writeValue(file, list);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Car getCar(int id) {
        Car car = null;
        List<Car> cars = getAllCars();
        for (Car c : cars) {
            if (c.getId() == id) {
                car = c;
                break;
            }
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> list = null;
        try {
            list =  mapper.readValue(file, new TypeReference<List<Car>>(){});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
