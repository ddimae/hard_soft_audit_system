package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.PeripheralEquipment;
import com.comp.ComputerAccounting.service.PeripheralEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PeripheralEquipmentController {

    private final PeripheralEquipmentService peripheralEquipmentService;

    @Autowired
    public PeripheralEquipmentController(PeripheralEquipmentService peripheralEquipmentService) {
        this.peripheralEquipmentService = peripheralEquipmentService;
    }

    @GetMapping("/peripheralEquipmentList")
    public String findAll(Model model){
        List<PeripheralEquipment> peripheralEquipments = peripheralEquipmentService.findAll();
        model.addAttribute("peripheralEquipments", peripheralEquipments);
        return "/peripheralEquipmentList";
    }

    @GetMapping("/peripheralEquipment-create")
    public String createPeripheralEquipmentForm(PeripheralEquipment peripheralEquipment){
        return "/peripheralEquipment-create";
    }

    @PostMapping("/peripheralEquipment-create")
    public String createPeripheralEquipment(PeripheralEquipment peripheralEquipment){
        peripheralEquipmentService.savePeripheralEquipment(peripheralEquipment);
        return "redirect:/peripheralEquipmentList";
    }

    @GetMapping("/peripheralEquipment-delete/{id}")
    public String deletePeripheralEquipment(@PathVariable("id") Integer id){
        peripheralEquipmentService.deletePeripheralEquipmentById(id);
        return "redirect:/peripheralEquipmentList";
    }

    @GetMapping("peripheralEquipment-update/{id}")
    public String updatePeripheralEquipmentForm(@PathVariable("id") Integer id, Model model){
        PeripheralEquipment peripheralEquipment = peripheralEquipmentService.findPeripheralEquipmentById(id);
        model.addAttribute("peripheralEquipment", peripheralEquipment);
        return "/peripheralEquipment-update";
    }

    @PostMapping("/peripheralEquipment-update")
    public String updatePeripheralEquipment(PeripheralEquipment peripheralEquipment){
        peripheralEquipmentService.savePeripheralEquipment(peripheralEquipment);
        return "redirect:/peripheralEquipmentList";
    }
}

