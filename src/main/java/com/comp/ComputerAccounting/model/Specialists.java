package com.comp.ComputerAccounting.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Specialists")
public class Specialists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSpecialist;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name="email")
    private String email;

    @ToString.Exclude
    @OneToMany(mappedBy = "specialists", cascade = { CascadeType.ALL })
    private List<SoftwareInstallation> softwareInstallations;
}