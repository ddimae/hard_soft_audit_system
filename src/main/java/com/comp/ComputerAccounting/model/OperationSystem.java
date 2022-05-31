package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Operation_system")
public class OperationSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOS;

    @Column(name = "type_OS_name")
    private String typeOSname;

    @OneToMany(mappedBy = "operationSystem", cascade = { CascadeType.ALL })
    private List<ComputerOS> computerOS;

}

