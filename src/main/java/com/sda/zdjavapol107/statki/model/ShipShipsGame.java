package com.sda.zdjavapol107.statki.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShipShipsGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipId;
    private int shipSize;
    boolean shipDestroyed;
    @ManyToOne
    List<PointShipsGame> localization;

    @OneToMany(mappedBy = "shipsUserOne")
    private BoardShipsGame boardShipsUserOne;
    @OneToMany(mappedBy = "shipsUserTwo")
    private BoardShipsGame boardShipsUserTwo;


    public ShipShipsGame(int shipSize, List<PointShipsGame> localization, boolean shipDestroyed) {
        this.shipSize = shipSize;
        this.localization = localization;
        this.shipDestroyed = shipDestroyed;
    }
}
