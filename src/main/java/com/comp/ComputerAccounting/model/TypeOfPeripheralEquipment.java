package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Type_of_peripheral_equipment")
public class TypeOfPeripheralEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypePeripheralEquipment;

    @Column(name = "name_type_peripheral_equipment")
    private String nameTypePeripheralEquipment;

    @OneToMany(mappedBy = "typeOfPeripheralEquipment", cascade = { CascadeType.ALL })
    private List<PeripheralEquipment> peripheralEquipments;
}

