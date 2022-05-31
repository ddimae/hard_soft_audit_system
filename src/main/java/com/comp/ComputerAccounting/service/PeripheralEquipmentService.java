package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.PeripheralEquipment;
import com.comp.ComputerAccounting.repository.PeripheralEquipmentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeripheralEquipmentService {

    private final PeripheralEquipmentRep peripheralEquipmentRep;

    @Autowired
    public PeripheralEquipmentService(PeripheralEquipmentRep peripheralEquipmentRep) {
        this.peripheralEquipmentRep = peripheralEquipmentRep;
    }

    public List<PeripheralEquipment> findAll(){
        return peripheralEquipmentRep.findAll();
    }

    public PeripheralEquipment savePeripheralEquipment(PeripheralEquipment peripheralEquipment){
        return peripheralEquipmentRep.save(peripheralEquipment);
    }

    public void deletePeripheralEquipmentById(Integer id){
        peripheralEquipmentRep.deleteById(id);
    }

    public PeripheralEquipment findPeripheralEquipmentById(Integer id){
        return peripheralEquipmentRep.getOne(id);
    }
}

