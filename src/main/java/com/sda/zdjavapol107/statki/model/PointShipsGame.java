package com.sda.zdjavapol107.statki.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PointShipsGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pointId;
    private int x; //String
    private int y;

    @OneToOne
    private ShipShipsGame shipSinglePoint;

    @OneToMany(mappedBy = "playBoardUserOne")
    private BoardShipsGame boardUserOne;
    @OneToMany(mappedBy = "playBoardUserTwo")
    private BoardShipsGame boardUserTwo;

    @OneToMany(mappedBy = "shootsHistory")
    private GameHistoryShips gameHistoryShips;

    public PointShipsGame(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
