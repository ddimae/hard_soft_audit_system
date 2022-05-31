package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;


public class ComputerServiceTests {

    private ComputerService computerService;
    private Integer id = 7;

    @BeforeAll
    public void setUp()
    {
        Computer computer = new Computer();
    }

    @Test
    public void findComputerById(){
        Computer computer = computerService.findComputerById(7);
        Assertions.assertNotNull(computer);
    }

    @Test
    public void saveComputer(){
        Computer computer = new Computer();
        computerService.saveComputer(computer);
        Assertions.assertNotNull(computerService.findComputerById(20));
    }

    @Test
    public void findAll(){
        List<Computer> computers = computerService.findAll();
        Assertions.assertNotNull(computers);
    }

    @Test
    public void search(){
        String str = "Desktop 1";
        List<Computer> computers = computerService.search(str);
        Assertions.assertNotNull(computers);
    }
}
