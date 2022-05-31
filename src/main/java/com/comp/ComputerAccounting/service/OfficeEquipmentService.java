package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.OfficeEquipment;
import com.comp.ComputerAccounting.repository.OfficeEquipmentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeEquipmentService {

    private final OfficeEquipmentRep officeEquipmentRep;

    @Autowired
    public OfficeEquipmentService(OfficeEquipmentRep officeEquipmentRep) {
        this.officeEquipmentRep = officeEquipmentRep;
    }

    public OfficeEquipment saveOfficeEquipment(OfficeEquipment officeEquipment){
        return officeEquipmentRep.save(officeEquipment);
    }

    public List<OfficeEquipment> findAll(){
        return officeEquipmentRep.findAll();
    }

    public void deleteOfficeEquipmentById(Integer id){
        officeEquipmentRep.deleteById(id);
    }

    public OfficeEquipment findOfficeEquipmentById(Integer id){
        return officeEquipmentRep.getOne(id);
    }
}

