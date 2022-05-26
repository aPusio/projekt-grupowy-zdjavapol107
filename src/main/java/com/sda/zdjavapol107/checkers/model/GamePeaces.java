package com.sda.zdjavapol107.checkers.model;

import com.sda.zdjavapol107.checkers.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class GamePeaces {
    @Id
    private Long id;
    @OneToMany(mappedBy = "player")
//  @JoinColumn(name = "id")
    @Column(name = "player_id")
    private Player playerId;
    private Character color;
    private boolean type;
    private boolean status;
    @Column(name = "position_x_axis")
    private Integer positionXAxis;
    @Column (name = "position_y_axis")
    private Integer positionYAxis;



}
