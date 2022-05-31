package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.Program;
import com.comp.ComputerAccounting.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/programList")
    public String findAll(Model model){
        List<Program> programs = programService.findAll();
        model.addAttribute("programs", programs);
        return "/programList";
    }

    @GetMapping("/program-create")
    public String createProgramForm(Program program){
        return "/program-create";
    }

    @PostMapping("/program-create")
    public String createProgram(Program program){
        programService.saveProgram(program);
        return "redirect:/programList";
    }

    @GetMapping("/program-delete/{id}")
    public String deleteProgram(@PathVariable("id") Integer id){
        programService.deleteProgramById(id);
        return "redirect:/programList";
    }

    @GetMapping("programService-update/{id}")
    public String updateProgramForm(@PathVariable("id") Integer id, Model model){
        Program program = programService.findProgramById(id);
        model.addAttribute("program", program);
        return "/program-update";
    }

    @PostMapping("/program-update")
    public String updateProgram(Program program){
        programService.saveProgram(program);
        return "redirect:/programList";
    }
}

