package ru.tinyakov.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.tinyakov.entity.Car;
import ru.tinyakov.exceptions.CarServicesException;
import ru.tinyakov.services.ICarServices;

import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class MainApp {

    @Autowired
    private ICarServices service;


    public void setService(ICarServices service) {
        this.service = service;
    }

    @GetMapping(value = "/cars")
    public String cars(Model model) {
        try {
            model.addAttribute("cars", service.get());
        } catch (CarServicesException e) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
        }
        return "index";
    }

    @GetMapping("/cars/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        try {
            model.addAttribute("car", service.get(id));
        } catch (CarServicesException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "add";
    }

    @GetMapping("/cars/add")
    public String add(Model model) {
        model.addAttribute("car", new Car());
        return "add";
    }


    //    String jsonStr
    @PostMapping(value = "/cars/insert", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String insert(Model model, @RequestBody String carString) {

        Stack<String> st = new Stack<>();
        st.push("str1");
        st.push("str2");
        st.push("str3");
        st.push("str4");

        System.out.println(st.toString());


        ObjectMapper mapper = new ObjectMapper();
        Car car = null;
        try {
            car = mapper.readValue(carString, Car.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (car.getId() > 0) {
                service.update(car);
            } else {
                service.insert(car);
            }
            model.addAttribute("cars", service.get());
        } catch (CarServicesException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
        return "index";
    }
/*

    @PostMapping(value = "/cars/insert", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String insert(Model model, @RequestBody Car car) {
        try {
            if (car.getId() > 0) {
                service.update(car);
            } else {
                service.insert(car);
            }
            model.addAttribute("cars", service.get());
        } catch (CarServicesException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
        return "index";
    }
*/

    @GetMapping("/cars/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        try {
            service.delete(id);
            model.addAttribute("cars", service.get());
        } catch (CarServicesException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
