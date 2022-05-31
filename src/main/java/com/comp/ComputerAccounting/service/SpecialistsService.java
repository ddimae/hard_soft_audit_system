package com.comp.ComputerAccounting.service;

import com.comp.ComputerAccounting.model.Specialists;
import com.comp.ComputerAccounting.repository.SpecialistsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistsService {

    private final SpecialistsRep specialistsRep;

    @Autowired
    public SpecialistsService(SpecialistsRep specialistsRep) {
        this.specialistsRep = specialistsRep;
    }

    public List<Specialists> findAll(){
        return specialistsRep.findAll();
    }

    public Specialists saveSpecialists(Specialists specialists){
        return specialistsRep.save(specialists);
    }

    public void deleteSpecialistsById(Integer id){
        specialistsRep.deleteById(id);
    }

    public Specialists findSpecialistsById(Integer id){
        return specialistsRep.getOne(id);
    }
}

