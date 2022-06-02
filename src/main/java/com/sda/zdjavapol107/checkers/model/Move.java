package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity

public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Player player;
    @ManyToOne
    private GamePeaces gamePeace;
    @Column(name = "new_position_x_axis")
    private Integer newPositionXAxis;
    @Column(name = "new_position_y_axis")
    private Integer newPositionYAxis;
    @ManyToOne
    private Game game;

    public Move(Player player, GamePeaces gamePeace, Integer newPositionXAxis, Integer newPositionYAxis, Game game) {
        this.player = player;
        this.gamePeace = gamePeace;
        this.newPositionXAxis = newPositionXAxis;
        this.newPositionYAxis = newPositionYAxis;
        this.game = game;
    }
}
