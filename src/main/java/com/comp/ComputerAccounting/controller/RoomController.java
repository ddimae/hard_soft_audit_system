package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.Room;
import com.comp.ComputerAccounting.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room-list/{id}")
    public String findAll(@PathVariable("id") Integer id, Model model){
        Room room = roomService.findRoomById(id);
        model.addAttribute("room", room);
        return "/roomList";
    }

    @GetMapping("/room-create")
    public String createRoomForm(Room room){
        return "/room-create";
    }

    @PostMapping("/room-create")
    public String createRoom(Room room){
        roomService.saveRoom(room);
        return "redirect:/roomList";
    }

    @GetMapping("/room-delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id){
        roomService.deleteRoomById(id);
        return "redirect:/roomList";
    }

    @GetMapping("room-update/{id}")
    public String updateRoomForm(@PathVariable("id") Integer id, Model model){
        Room room = roomService.findRoomById(id);
        model.addAttribute("room", room);
        return "/room-update";
    }

    @PostMapping("/room-update")
    public String updateRoom(Room room){
        roomService.saveRoom(room);
        return "redirect:/roomList";
    }
}

