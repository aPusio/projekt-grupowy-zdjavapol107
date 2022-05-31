package com.sda.zdjavapol107.statki.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
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

    private boolean isTop;

    private boolean isDown;
    private boolean isLeft;

    private boolean isRight;

    @OneToOne(mappedBy = "shipSinglePoint")
    private PointShipsGame point;

    @OneToMany(mappedBy = "shipsUserOne")
    private BoardShipsGame boardShipsUserOne;
    @OneToMany(mappedBy = "shipsUserTwo")
    private BoardShipsGame boardShipsUserTwo;

    public ShipShipsGame(int shipSize, boolean shipDestroyed, boolean isTop, boolean isRight, boolean isLeft,boolean isDown, PointShipsGame point) {
        this.shipSize = shipSize;
        this.shipDestroyed = shipDestroyed;
        this.isTop = isTop;
        this.isRight = isRight;
        this.isDown = isDown;
        this.isLeft = isLeft;
        this.point = point;
    }
}
