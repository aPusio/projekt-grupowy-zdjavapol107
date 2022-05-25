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
public class PointShipsGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pointId;
    private String x;
    private int y;
//    @OneToMany(mappedBy = "localization")
//    private ShipShipsGame shipShipsGame;

    @OneToMany(mappedBy = "playBoardUserOne")
    private List<BoardShipsGame> boardUserOne;
//    @OneToMany(mappedBy = "playBoardUserTwo")
//    private BoardShipsGame boardUserTwo;

//    @OneToMany(mappedBy = "shootsHistory")
//    private GameHistoryShips gameHistoryShips;



    public PointShipsGame(String x, int y) {
        this.x = x;
        this.y = y;
    }
}
