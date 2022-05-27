package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class GamePeaces {
    @Id
    private Long id;
    @ManyToOne
    private Player player;
    private Character color;
    private boolean type;
    private boolean status;
    @Column(name = "position_x_axis")
    private Integer positionXAxis;
    @Column(name = "position_y_axis")
    private Integer positionYAxis;
    @OneToMany(mappedBy = "gamePeace")
    private Set<Move> moves;
    @ManyToOne
    private Game game;


}
