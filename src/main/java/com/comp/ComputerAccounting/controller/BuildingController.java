package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.Building;
import com.comp.ComputerAccounting.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/building-list")
    public String findAll(Model model){
        List<Building> buildings = buildingService.findAll();
        model.addAttribute("buildings", buildings);
        return "buildingList.html";
    }

    @GetMapping("/building-create")
    public String createBuildingForm(Building building){
        return "/building-create";
    }

    @PostMapping("/building-create")
    public String createBuilding(Building building){
        buildingService.saveBuilding(building);
        return "redirect:/buildingList";
    }

    @GetMapping("/building-delete/{id}")
    public String deleteBuilding(@PathVariable("id") Integer id){
        buildingService.deleteById(id);
        return "redirect:/buildingList";
    }

    @GetMapping("building-update/{id}")
    public String updateBuildingForm(@PathVariable("id") Integer id, Model model){
        Building building = buildingService.findBuildingById(id);
        model.addAttribute("building", building);
        return "/building-update";
    }

    @PostMapping("/building-update")
    public String updateBuilding(Building building){
        buildingService.saveBuilding(building);
        return "redirect:/buildingList";
    }
}

