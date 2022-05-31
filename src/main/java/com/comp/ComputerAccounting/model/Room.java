package com.comp.ComputerAccounting.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoom;

    @Column(name="room_name")
    private String roomName;

    @Column(name = "floor")
    private Integer floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_building")
    private Building building;

    @ToString.Exclude
    @OneToMany(mappedBy = "room", cascade = { CascadeType.ALL })
    private List<OfficeEquipment> officeEquipments;

    @ToString.Exclude
    @OneToMany(mappedBy = "room", cascade = { CascadeType.ALL })
    private List<Computer> computers;
}

