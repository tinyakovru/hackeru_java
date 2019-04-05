package ru.tinyakov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.tinyakov.entity.Car;
import ru.tinyakov.entity.Maker;
import ru.tinyakov.exceptions.CarServicesException;
import ru.tinyakov.exceptions.MakerServicesException;
import ru.tinyakov.services.ICarServices;
import ru.tinyakov.services.IMakerServices;
import ru.tinyakov.services.MakerService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/maker")
public class MakerController {

    @Autowired
    private IMakerServices service;

    public void setService(IMakerServices service) {
        this.service = service;
    }

    @GetMapping("/")
    public String get(Model model){
        List<Maker> list = service.get();
        if (list == null){
            model.addAttribute("success", false);
            model.addAttribute("message", "empty");
            return "/maker/index";
        }
        model.addAttribute("categories", list);
        model.addAttribute("success", true);
        return "/maker/index";
    }

    @GetMapping("/add")
    public String view(Model model){
        model.addAttribute("category", new Maker());
        model.addAttribute("action", "insert");
        return "/maker/add";
    }

    @GetMapping("/edit/{id}")
    public String view(@PathVariable int id, Model model){

        Maker maker = service.get(id);
        if (maker != null){
            model.addAttribute("success", true);
            model.addAttribute("action", "/maker/update");
            model.addAttribute("maker", maker);
            return "/maker/add";
        }
        model.addAttribute("success", false);
        model.addAttribute("message", "upsss");
        return "/maker/add";
    }

    @PostMapping(value = "/update")
    public RedirectView update(@ModelAttribute(value = "maker") Maker maker, RedirectAttributes attributes){
        try {
            service.update(maker);
        } catch (MakerServicesException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/maker/");
    }

    @PostMapping(value = "/insert")
    public RedirectView insert(@ModelAttribute(value = "maker") Maker maker, RedirectAttributes attributes){
        try {
            service.insert(maker);
        } catch (MakerServicesException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/maker/");
    }

    @GetMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes){
        try {
            service.delete(id);
        } catch (MakerServicesException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/maker/");
    }
}
