package com.comp.ComputerAccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ComputerOSKey implements Serializable {

    @Column(name = "computer_id")
    private Integer idComputer;

    @Column(name = "OS_id")
    private Integer idOS;

}
