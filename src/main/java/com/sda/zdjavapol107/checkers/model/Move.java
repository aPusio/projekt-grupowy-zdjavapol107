package com.sda.zdjavapol107.checkers.model;

import com.sda.zdjavapol107.checkers.PawnMove;
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
    private long turn;
    @ManyToOne
    private Game game;

    public Move(Player player, GamePeaces gamePeace, PawnMove pawnMove, Game game) {
        this.player = player;
        this.gamePeace = gamePeace;
        this.newPositionXAxis = pawnMove.getNewPosition().getXAxis();
        this.newPositionYAxis = pawnMove.getNewPosition().getYAxis();
        this.turn = pawnMove.getTurn().getTurnNumber();
        this.game = game;
    }
}
