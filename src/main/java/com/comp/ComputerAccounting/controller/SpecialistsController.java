package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.Specialists;
import com.comp.ComputerAccounting.service.SpecialistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SpecialistsController {

    private final SpecialistsService specialistsService;

    @Autowired
    public SpecialistsController(SpecialistsService specialistsService) {
        this.specialistsService = specialistsService;
    }

    @GetMapping("/specialistsList")
    public String findAll(Model model){
        List<Specialists> specialists = specialistsService.findAll();
        model.addAttribute("specialists", specialists);
        return "/specialistsList";
    }

    @GetMapping("/specialists-create")
    public String createSpecialistsForm(Specialists specialists){

        return "/specialists-create";
    }

    @PostMapping("/specialists-create")
    public String createSpecialists(Specialists specialists){
        specialistsService.saveSpecialists(specialists);
        return "redirect:/specialistsList";
    }

    @GetMapping("/specialists-delete/{id}")
    public String deleteSpecialists(@PathVariable("id") Integer id){
        specialistsService.deleteSpecialistsById(id);
        return "redirect:/specialistsList";
    }

    @GetMapping("specialists-update/{id}")
    public String updateSpecialistsForm(@PathVariable("id") Integer id, Model model){
        Specialists specialists = specialistsService.findSpecialistsById(id);
        model.addAttribute("specialists", specialists);
        return "/specialists-update";
    }

    @PostMapping("/specialists-update")
    public String updateSpecialists(Specialists specialists){
        specialistsService.saveSpecialists(specialists);
        return "redirect:/specialistsList";
    }
}

