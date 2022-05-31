package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.Building;
import com.comp.ComputerAccounting.repository.BuildingRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRep buildingRep;

    @Autowired
    public BuildingService(BuildingRep buildingRep) {
        this.buildingRep = buildingRep;
    }

    public List<Building> findAll(){ return buildingRep.findAll();
    }
    public Building saveBuilding(Building building) {
        return buildingRep.save(building);
    }

    public void deleteById(Integer id){
        buildingRep.deleteById(id);
    }

    public Building findBuildingById(Integer id){
        return buildingRep.getOne(id);
    }
}

