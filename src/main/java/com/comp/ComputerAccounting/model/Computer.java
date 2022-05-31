package com.comp.ComputerAccounting.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComputer;

    @Column(name="computer_name_in_local_network")
    private String computerNameInLocalNetwork;

    @ToString.Exclude
    @OneToMany(mappedBy = "computer", cascade = { CascadeType.ALL})
    private List<SoftwareInstallation> softwareInstallations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    private Room room;

    @ToString.Exclude
    @OneToMany(mappedBy = "computer", cascade = { CascadeType.ALL })
    private List<ComputerEquipment> computerEquipments;

    @ToString.Exclude
    @OneToMany(mappedBy = "computer", cascade = { CascadeType.ALL })
    private List<ComputerOS> computerOS;

}