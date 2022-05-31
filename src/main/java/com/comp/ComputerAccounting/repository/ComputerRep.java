package com.comp.ComputerAccounting.repository;

import com.comp.ComputerAccounting.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerRep extends JpaRepository<Computer, Integer>{

    List<Computer> findByComputerNameInLocalNetworkStartingWith(String name);
}
