package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.Room;
import com.comp.ComputerAccounting.repository.RoomRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService{

    private final RoomRep roomRep;

    @Autowired
    public RoomService(RoomRep roomRep) {
        this.roomRep = roomRep;
    }

    public List<Room> findAll(){
        return roomRep.findAll();
    }

    public List<Room> findRoomByBuilding_IdBuilding(Integer id) {return roomRep.findRoomsByBuilding_IdBuilding(id);}

    public Room saveRoom(Room room){
        return roomRep.save(room);
    }

    public void deleteRoomById(Integer id){
        roomRep.deleteById(id);
    }

    public Room findRoomById(Integer id){
        return roomRep.getOne(id);
    }
}

