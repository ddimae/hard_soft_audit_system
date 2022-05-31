package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ComputerEquipmentKey implements Serializable {

    @Column(name = "computer_id")
    private Integer idComputer;

    @Column(name = "peripheral_equipment_id")
    private Integer idPeripheralEquipment;

}