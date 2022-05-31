package com.comp.ComputerAccounting.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBuilding;

    @Column(name = "location")
    private String location;

    @Column(name = "building_name")
    private String buildingName;

    @ToString.Exclude
    @OneToMany(mappedBy = "building", cascade = { CascadeType.ALL })
    private List<Room> rooms;
}