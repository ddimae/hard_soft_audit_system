package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Peripheral_equipment")
public class PeripheralEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPeripheralEquipment;

    @Column(name="serial_number_of_the_equipment")
    private Integer serialNumberOfTheEquipment;

    @Column(name = "model_of_equipment")
    private String modelOfEquipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_peripheral_equipment")
    private TypeOfPeripheralEquipment typeOfPeripheralEquipment;

    @OneToMany(mappedBy = "peripheralEquipment", cascade = { CascadeType.ALL })
    private List<ComputerEquipment> computerEquipments;
}

