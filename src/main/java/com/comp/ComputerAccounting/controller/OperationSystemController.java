package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.OperationSystem;
import com.comp.ComputerAccounting.service.OperationSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OperationSystemController {

    private final OperationSystemService operationSystemService;

    @Autowired
    public OperationSystemController(OperationSystemService operationSystemService) {
        this.operationSystemService = operationSystemService;
    }

    @GetMapping("/operationSystemList")
    public String findAll(Model model){
        List<OperationSystem> operationSystems = operationSystemService.findAll();
        model.addAttribute("operationSystems", operationSystems);
        return "/operationSystemList";
    }

    @GetMapping("/operationSystem-create")
    public String createOperationSystemForm(OperationSystem operationSystem)
    {
        return "/operationSystem-create";
    }

    @PostMapping("/operationSystem-create")
    public String createOperationSystem(OperationSystem operationSystem){
        operationSystemService.saveOperationSystem(operationSystem);
        return "redirect:/operationSystemList";
    }

    @GetMapping("/operationSystem-delete/{id}")
    public String updateOperationSystem(@PathVariable("id") Integer id){
        operationSystemService.deleteOperationSystemById(id);
        return "redirect:/operationSystemList";
    }

    @GetMapping("operationSystem-update/{id}")
    public String updateOperationSystemForm(@PathVariable("id") Integer id, Model model){
        OperationSystem operationSystem = operationSystemService.findOperationSystemById(id);
        model.addAttribute("operationSystem", operationSystem);
        return "/operationSystem-update";
    }

    @PostMapping("/operationSystem-update")
    public String updateOperationSystem(OperationSystem operationSystem){
        operationSystemService.saveOperationSystem(operationSystem);
        return "redirect:/operationSystemList";
    }
}

