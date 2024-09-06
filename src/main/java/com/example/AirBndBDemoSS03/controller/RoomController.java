package com.example.AirBndBDemoSS03.controller;

import com.example.AirBndBDemoSS03.entity.Property;
import com.example.AirBndBDemoSS03.entity.Room;
import com.example.AirBndBDemoSS03.hepler.MyHelperExcel;
import com.example.AirBndBDemoSS03.repo.PropertyRepository;
import com.example.AirBndBDemoSS03.repo.RoomRepository;
import com.example.AirBndBDemoSS03.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/airbnb/v1/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomsRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<Room> addDetails(@RequestParam long propertyId, @RequestBody Room rooms) {
        Property pro = propertyRepository.findById(propertyId).get();
        rooms.setProperty(pro);
        Room save = roomsRepository.save(rooms);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PostMapping()
public ResponseEntity<?>addDetailsFromExcel(@RequestParam ("file")MultipartFile file) throws IOException {
        if (MyHelperExcel.checkExcelFormat(file)){
            roomService.saveFile(file);
            return new ResponseEntity<>("file uploaded data is saved to Database",HttpStatus.CREATED);
        }else {
        return  new ResponseEntity<>("file is not appropiate",HttpStatus.BAD_REQUEST);
    }    }
    @GetMapping("/get")
    public List<Room> getAllDetails(@RequestParam int pageNo,@RequestParam int pageSize,
                                    @RequestParam String field){
        List<Room> allRoomDetails = roomService.getAllRoomDetails(pageNo, pageSize, field);
    return allRoomDetails;
    }
}

