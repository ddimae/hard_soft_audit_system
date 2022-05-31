package com.comp.ComputerAccounting.repository;

import com.comp.ComputerAccounting.model.ComputerEquipment;
import com.comp.ComputerAccounting.model.ComputerEquipmentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerEquipmentRep extends JpaRepository<ComputerEquipment, ComputerEquipmentKey> {
}

