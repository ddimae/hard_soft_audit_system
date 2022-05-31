package com.comp.ComputerAccounting.model;

import lombok.AccessLevel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "software_installation")
public class SoftwareInstallation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int softwareInstallationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "computer_id")
    private Computer computer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private Program program;

    @Column(name = "date_of_installation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfInstallation;

    @Column(name = "program_size")
    private Integer programSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialists_id")
    private Specialists specialists;
}

