package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.OperationSystem;
import com.comp.ComputerAccounting.repository.OperationSystemRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationSystemService {

    private final OperationSystemRep operationSystemRep;

    @Autowired
    public OperationSystemService(OperationSystemRep operationSystemRep) {
        this.operationSystemRep = operationSystemRep;
    }

    public List<OperationSystem> findAll(){
        return operationSystemRep.findAll();
    }

    public OperationSystem saveOperationSystem(OperationSystem operationSystem){
        return operationSystemRep.save(operationSystem);
    }

    public void deleteOperationSystemById(Integer id){
        operationSystemRep.deleteById(id);
    }

    public OperationSystem findOperationSystemById(Integer id){
        return operationSystemRep.getOne(id);
    }
}

