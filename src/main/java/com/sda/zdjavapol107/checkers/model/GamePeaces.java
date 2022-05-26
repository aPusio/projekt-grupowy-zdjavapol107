package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class GamePeaces {
    @Id
    private Long id;
//    @OneToMany(mappedBy = "player")
//  @JoinColumn(name = "id")
    @Column(name = "player_id")
    private Long playerId;
    private Character color;
    private boolean type;
    private boolean status;
    @Column(name = "position_x_axis")
    private Integer positionXAxis;
    @Column (name = "position_y_axis")
    private Integer positionYAxis;



}
