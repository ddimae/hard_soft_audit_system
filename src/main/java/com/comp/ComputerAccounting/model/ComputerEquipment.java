package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Computer_equipment")
public class ComputerEquipment {

    @EmbeddedId
    ComputerEquipmentKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPeripheralEquipment")
    @JoinColumn(name = "peripheral_equipment_id")
    private PeripheralEquipment peripheralEquipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idComputer")
    @JoinColumn(name = "computer_id")
    private Computer computer;

    @Column(name = "note")
    private String note;
}