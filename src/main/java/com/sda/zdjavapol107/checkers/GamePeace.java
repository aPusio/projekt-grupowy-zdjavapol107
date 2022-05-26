package com.sda.zdjavapol107.checkers;

import jakarta.persistence.*;
import lombok.extern.java.Log;
import org.hibernate.annotations.JavaType;

@Entity
public class GamePeace {
    @Id
    private Long id;
    @OneToMany(mappedBy = "player")
    @JoinColumn(name = "id")
    private Player player_id;
    private String color;
    private boolean type;
    private boolean status;
    @Column(name = "position_x_axis")
    private Integer positionXAxis;
    @Column (name = "position_y_axis")
    private Integer positionYAxis;



}
