package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class GamePeaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Player player;
    private Character color;
    private boolean isDame;
    private boolean inGame;
    @Column(name = "position_x_axis")
    private Integer positionXAxis;
    @Column(name = "position_y_axis")
    private Integer positionYAxis;
    @OneToMany(mappedBy = "gamePeace")
    private Set<Move> moves;
    @ManyToOne
    private Game game;

    public GamePeaces(Player player, Character color, boolean isDame, boolean inGame, Game game) {
        this.player = player;
        this.color = color;
        this.isDame = isDame;
        this.inGame = inGame;
        this.game = game;
    }

    public GamePeaces(Player player, Character color, boolean isDame, boolean inGame, Integer positionXAxis, Integer positionYAxis, Game game) {
        this.player = player;
        this.color = color;
        this.isDame = isDame;
        this.inGame = inGame;
        this.positionXAxis = positionXAxis;
        this.positionYAxis = positionYAxis;
        this.game = game;
    }
}
