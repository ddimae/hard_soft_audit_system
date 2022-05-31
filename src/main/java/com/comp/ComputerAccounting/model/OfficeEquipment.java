package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Office_equipment")
public class OfficeEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOfficeEquipment;

    @Column(name = "warranty_card")
    private boolean warrantyCard;

    @Column(name = "sample_name")
    private String sampleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_office_equipment")
    private TypeOfTheOfficeEquipment typeOfTheOfficeEquipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    private Room room;
}
