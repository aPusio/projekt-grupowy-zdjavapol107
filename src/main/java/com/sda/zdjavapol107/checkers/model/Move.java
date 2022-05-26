package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity

public class Move {

    @Id
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
}
