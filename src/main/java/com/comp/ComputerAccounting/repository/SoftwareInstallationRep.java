package com.comp.ComputerAccounting.repository;

import com.comp.ComputerAccounting.model.SoftwareInstallation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareInstallationRep extends JpaRepository<SoftwareInstallation, Integer>{
}
