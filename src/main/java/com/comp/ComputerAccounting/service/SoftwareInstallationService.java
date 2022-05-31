package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.SoftwareInstallation;
import com.comp.ComputerAccounting.repository.SoftwareInstallationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareInstallationService {

    private final SoftwareInstallationRep softwareInstallationRep;

    @Autowired
    public SoftwareInstallationService(SoftwareInstallationRep softwareInstallationRep) {
        this.softwareInstallationRep = softwareInstallationRep;
    }

    public List<SoftwareInstallation> findAll(){
        return softwareInstallationRep.findAll();
    }

    public void saveSoftwareInstallation(SoftwareInstallation softwareInstallation){
        softwareInstallationRep.save(softwareInstallation);
    }

    public void deleteSoftwareInstallation(Integer id){
        softwareInstallationRep.deleteById(id);
    }

    public SoftwareInstallation findSoftwareInstallationById(Integer id){
        return softwareInstallationRep.getOne(id);
    }
}

