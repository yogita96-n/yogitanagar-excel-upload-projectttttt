package com.example.AirBndBDemoSS03.controller;

import com.example.AirBndBDemoSS03.entity.Property;
import com.example.AirBndBDemoSS03.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/airbnb/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Property> addProperty(@RequestBody Property property){

        Property property1 = propertyService.addProperty(property);


        return  new ResponseEntity<>(property1, HttpStatus.CREATED);
    }
}
