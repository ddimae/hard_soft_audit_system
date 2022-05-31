package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.Program;
import com.comp.ComputerAccounting.repository.ProgramRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    private final ProgramRep programRep;

    @Autowired
    public ProgramService(ProgramRep programRep) {
        this.programRep = programRep;
    }

    public List<Program> findAll() {
        return programRep.findAll();
    }

    public Program saveProgram(Program program){
        return programRep.save(program);
    }

    public void deleteProgramById(Integer id){
        programRep.deleteById(id);
    }

    public Program findProgramById(Integer id){
        return programRep.getOne(id);
    }
}

