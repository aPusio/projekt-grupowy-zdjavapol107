package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity

public class Move {

    @Id
    private Long id;
//    @OneToMany
//    @JoinColumn(name = "id")
    private Long player_id;
//    @JoinColumn(name = "id")
    private Long gamePeaceId;
    @Column(name = "new_position_x_axis")
    private Integer newPositionXAxis;
    @Column(name = "new_position_y_axis")
    private Integer newPositionYAxis;
}
