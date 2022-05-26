package com.sda.zdjavapol107.checkers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class GamePeaces {

    @Id
    private Integer id;
    private Integer playerId;
    private Character color;
    private boolean isDefaultPeace;
    private boolean inGame;
    private Integer positionXAxis;
    private Integer positionYAxis;

}
