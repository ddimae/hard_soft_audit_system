package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.Computer;
import com.comp.ComputerAccounting.repository.ComputerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {

    private final ComputerRep computerRep;

    @Autowired
    public ComputerService(ComputerRep computerRep) {
        this.computerRep = computerRep;
    }

    public List<Computer> findAll(){ return computerRep.findAll(); }
    public void deleteComputerById(Integer id) { computerRep.deleteById(id); }
    public List<Computer> search(String keyword) {
        return computerRep.findByComputerNameInLocalNetworkStartingWith(keyword);
    }
    public Computer findComputerById(Integer id) { return computerRep.getOne(id); }
    public Computer saveComputer(Computer computer){ return computerRep.save(computer); }
}

