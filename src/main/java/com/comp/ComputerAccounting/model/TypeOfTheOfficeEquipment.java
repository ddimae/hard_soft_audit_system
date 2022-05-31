package com.comp.ComputerAccounting.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Type_of_the_office_equipment")
public class TypeOfTheOfficeEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeOfficeEquipment;

    @Column(name = "name_type_office_equipmrnt")
    private String nameTypeOfficeEquipment;

    @ToString.Exclude
    @OneToMany(mappedBy = "typeOfTheOfficeEquipment", cascade = { CascadeType.ALL })
    private List<OfficeEquipment> officeEquipments;
}

