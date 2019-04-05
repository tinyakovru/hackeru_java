package ru.tinyakov.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.tinyakov.entity.Car;
import ru.tinyakov.entity.Maker;
import ru.tinyakov.exceptions.CarServicesException;
import ru.tinyakov.services.ICarServices;
import ru.tinyakov.services.IMakerServices;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private ICarServices service;

    @Autowired
    private IMakerServices serviceMaker;

    public void setService(ICarServices service) {
        this.service = service;
    }

    public void setServiceMaker(IMakerServices serviceMaker) {
        this.serviceMaker = serviceMaker;
    }

    @GetMapping(value = "/")
    public String cars(Model model) {
        List<Car> list = service.get();
        if (list == null){
            model.addAttribute("success", false);
            model.addAttribute("message", "В продаже нет машин");
            return "/cars/index";
        }
        model.addAttribute("cars", list);
        model.addAttribute("success", true);
        return "/cars/index";
    }

    @GetMapping("/add")
    public String view(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("maker",serviceMaker.get());
        model.addAttribute("action", "insert");
        return "/cars/add";
    }
    /*
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("car", new Car());
        return "/cars/add";
    }
    */
    /*
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        try {
            model.addAttribute("car", service.get(id));
        } catch (CarServicesException ex) {
            Logger.getLogger(CarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/cars/add";
    }
    */

    @GetMapping("/edit/{id}")
    public String view(@PathVariable int id, Model model){

        Car car = service.get(id);
        if (car != null){
            model.addAttribute("success", true);
            model.addAttribute("action", "/cars/update");
            model.addAttribute("car", car);
            model.addAttribute("categories", serviceMaker.get());
            return "/cars/add";
        }
        model.addAttribute("success", false);
        model.addAttribute("message", "Upps");
        return "/cars/index";
    }

    @PostMapping(value = "/update")
    public RedirectView update(@ModelAttribute(value = "car") Car car, RedirectAttributes attributes){
        try {
            service.update(car);
        } catch (CarServicesException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/cars/");
    }

    @PostMapping(value = "/insert")
    public RedirectView insert(@ModelAttribute(value = "car") Car car,
                               BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            System.out.println(result.toString());
        }
        try {
            service.insert(car);
        } catch (CarServicesException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/cars/");
    }

    @GetMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes){
        try {
            service.delete(id);
        } catch (CarServicesException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/cars/");
    }

    @PostMapping(value = "/insert")
    public String insert(@ModelAttribute(value = "car") Car car, Model model ) {
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
        return "/cars/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        try {
            service.delete(id);
            model.addAttribute("car", service.get());
        } catch (CarServicesException e) {
            e.printStackTrace();
        }
        return "/cars/index";
    }
}
