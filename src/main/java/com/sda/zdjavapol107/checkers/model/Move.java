package com.sda.zdjavapol107.checkers.model;

import com.sda.zdjavapol107.checkers.Player;
import com.sda.zdjavapol107.checkers.model.GamePeace;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
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
