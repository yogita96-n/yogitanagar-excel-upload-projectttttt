package com.example.AirBndBDemoSS03.service;

import com.example.AirBndBDemoSS03.entity.Room;
import com.example.AirBndBDemoSS03.hepler.MyHelperExcel;
import com.example.AirBndBDemoSS03.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class RoomService {
@Autowired
private RoomRepository roomRepository;
public void saveFile(MultipartFile file) throws IOException {
    List<Room> rooms = MyHelperExcel.convertExcelToListOfRoom(file.getInputStream());
roomRepository.saveAll(rooms);
}

public List<Room>getAllRoomDetails(int pageNo, int pageSize, String field){
    Page<Room> all = roomRepository.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.by(field)));
    return all.getContent();
}

}
