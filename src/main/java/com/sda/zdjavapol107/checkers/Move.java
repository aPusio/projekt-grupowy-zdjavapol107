package com.sda.zdjavapol107.checkers;

import jakarta.persistence.*;

@Entity
public class Move {

    @Id
    private Long id;
    @OneToMany
    @JoinColumn(name = "id")
    private Player player_id;
    @JoinColumn(name = "id")
    private GamePeace gamePeaceId;
    @Column(name = "new_position_x_axis")
    private Integer newPositionXAxis;
    @Column(name = "new_position_y_axis")
    private Integer newPositionYAxis;
}
