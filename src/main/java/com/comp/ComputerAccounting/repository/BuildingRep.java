package com.comp.ComputerAccounting.repository;

import com.comp.ComputerAccounting.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRep extends JpaRepository<Building, Integer> {
}
