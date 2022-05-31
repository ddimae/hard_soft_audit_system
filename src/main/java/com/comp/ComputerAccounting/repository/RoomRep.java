package com.comp.ComputerAccounting.repository;

import com.comp.ComputerAccounting.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRep extends JpaRepository<Room, Integer>{

    List<Room> findRoomsByBuilding_IdBuilding(@Param("idBuilding") Integer id);
}
