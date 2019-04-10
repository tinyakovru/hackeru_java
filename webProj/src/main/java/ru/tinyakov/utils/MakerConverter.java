/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyakov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.tinyakov.entity.Maker;
import ru.tinyakov.services.IMakerServices;


public class MakerConverter implements Converter<String, Maker>{

    
    @Autowired
    IMakerServices service;

    public void setService(IMakerServices service) {
        this.service = service;
    }

    @Override
    public Maker convert(String s) {
        return service.get(Integer.parseInt(s));
    }
    
    
    
    
}
