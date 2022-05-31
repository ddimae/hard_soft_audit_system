package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Computer_OS")
public class ComputerOS {

    @EmbeddedId
    private ComputerOSKey computerOSKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idComputer")
    @JoinColumn(name = "computer_id")
    private Computer computer;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idOS")
    @JoinColumn(name = "os_id")
    private OperationSystem operationSystem;

    @Column(name = "priority_OS")
    private Integer priorityOS;
}

