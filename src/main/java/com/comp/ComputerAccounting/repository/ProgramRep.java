package com.comp.ComputerAccounting.repository;

import com.comp.ComputerAccounting.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRep extends JpaRepository<Program, Integer>{
}
