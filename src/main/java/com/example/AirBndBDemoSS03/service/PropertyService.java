package com.example.AirBndBDemoSS03.service;

import com.example.AirBndBDemoSS03.entity.Property;
import com.example.AirBndBDemoSS03.repo.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;


    public Property addProperty(Property property) {

        Property save = propertyRepository.save(property);
        return save;
    }
}
