package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.OfficeEquipment;
import com.comp.ComputerAccounting.service.OfficeEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OfficeEquipmentController {

    private final OfficeEquipmentService officeEquipmentService;

    @Autowired
    public OfficeEquipmentController(OfficeEquipmentService officeEquipmentService) {
        this.officeEquipmentService = officeEquipmentService;
    }

    @GetMapping("/officeEquipmentList")
    public String findAll(Model model){
        List<OfficeEquipment> officeEquipments = officeEquipmentService.findAll();
        model.addAttribute("officeEquipments", officeEquipments);
        return "/officeEquipmentList";
    }

    @GetMapping("/officeEquipment-create")
    public String createOfficeEquipmentForm(OfficeEquipment officeEquipment){
        return "/officeEquipment-create";
    }

    @PostMapping("/officeEquipment-create")
    public String createOfficeEquipment(OfficeEquipment officeEquipment){
        officeEquipmentService.saveOfficeEquipment(officeEquipment);
        return "redirect:/officeEquipmentList";
    }

    @GetMapping("/officeEquipment-delete/{id}")
    public String deleteOfficeEquipment(@PathVariable("id") Integer id){
        officeEquipmentService.deleteOfficeEquipmentById(id);
        return "redirect:/officeEquipmentList";
    }

    @GetMapping("officeEquipment-update/{id}")
    public String updateOfficeEquipmentForm(@PathVariable("id") Integer id, Model model){
        OfficeEquipment officeEquipment = officeEquipmentService.findOfficeEquipmentById(id);
        model.addAttribute("officeEquipment", officeEquipment);
        return "/officeEquipment-update";
    }

    @PostMapping("/officeEquipment-update")
    public String updateOfficeEquipment(OfficeEquipment officeEquipment){
        officeEquipmentService.saveOfficeEquipment(officeEquipment);
        return "redirect:/officeEquipmentList";
    }
}

