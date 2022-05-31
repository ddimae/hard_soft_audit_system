package com.comp.ComputerAccounting.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgram;

    @Column(name = "installation_location")
    private String installationLocation;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "availability_of_the_installation_package")
    private boolean availabilityOfTheInstallationPackage;

    @ToString.Exclude
    @OneToMany(mappedBy = "program", cascade = { CascadeType.ALL })
    private List<SoftwareInstallation> softwareInstallations;
}

