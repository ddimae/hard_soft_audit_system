package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.Computer;
import com.comp.ComputerAccounting.model.Program;
import com.comp.ComputerAccounting.model.SoftwareInstallation;
import com.comp.ComputerAccounting.model.Specialists;
import com.comp.ComputerAccounting.service.ComputerService;
import com.comp.ComputerAccounting.service.ProgramService;
import com.comp.ComputerAccounting.service.SoftwareInstallationService;
import com.comp.ComputerAccounting.service.SpecialistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SoftwareInstallationController {

    private final SoftwareInstallationService softwareInstallationService;
    private final ProgramService programService;
    private final SpecialistsService specialistsService;
    private final ComputerService computerService;

    @Autowired
    public SoftwareInstallationController(SoftwareInstallationService softwareInstallationService, ProgramService programService, SpecialistsService specialistsService, ComputerService computerService) {
        this.softwareInstallationService = softwareInstallationService;
        this.programService = programService;
        this.specialistsService = specialistsService;
        this.computerService = computerService;
    }

    @GetMapping("/softwareInstallationList")
    public String findAll(Model model){
        List<SoftwareInstallation> softwareInstallations = softwareInstallationService.findAll();
        model.addAttribute("softwareInstallations", softwareInstallations);
        return "/softwareInstallationList";
    }

    @GetMapping("/softwareInstallation-create/{id}")
    public String createSoftwareInstallationForm(@PathVariable("id") Integer id, Model model){

        List<Program> programs = programService.findAll();
        model.addAttribute("programs", programs);

        List<Specialists> specialistsList = specialistsService.findAll();
        model.addAttribute("specialistsList", specialistsList);

        Computer computer = computerService.findComputerById(id);
        model.addAttribute("comp", computer);

        SoftwareInstallation softwareInstallation = new SoftwareInstallation();
        softwareInstallation.setComputer(computer);
        model.addAttribute("softwareInstallation", softwareInstallation);

        return "softwareInstallation-create.html";
    }

    @PostMapping("/softwareInstallation-create")
    public String createSoftwareInstallation(SoftwareInstallation softwareInstallation){
        softwareInstallationService.saveSoftwareInstallation(softwareInstallation);
        Integer id = softwareInstallation.getComputer().getIdComputer();
        return "redirect:/computer-list/"+id;
    }

    @GetMapping("/computerList/{computerID}/softwareInstallation-delete/{id}")
    public String deleteSoftwareInstallation(@PathVariable("id") Integer id, @PathVariable("computerID") Integer computerID){
        softwareInstallationService.deleteSoftwareInstallation(id);
        return "redirect:/computer-list/" + computerID;
    }

    @GetMapping("softwareInstallation-update/{id}")
    public String updateSoftwareInstallationForm(@PathVariable("id") Integer id, Model model){
        SoftwareInstallation softwareInstallation = softwareInstallationService.findSoftwareInstallationById(id);
        model.addAttribute("softwareInstallation", softwareInstallation);

        List<Program> programs = programService.findAll();
        model.addAttribute("programs", programs);

        List<Specialists> specialistsList = specialistsService.findAll();
        model.addAttribute("specialistsList", specialistsList);

        Computer computer = computerService.findComputerById(softwareInstallation.getComputer().getIdComputer());
        model.addAttribute("comp", computer);

        return "softwareInstallation-update.html";
    }

    @PostMapping("/softwareInstallation-update")
    public String updateSoftwareInstallation(SoftwareInstallation softwareInstallation){
        softwareInstallationService.saveSoftwareInstallation(softwareInstallation);
        Integer id = softwareInstallation.getComputer().getIdComputer();
        return "redirect:/computer-list/"+id;
    }
}

