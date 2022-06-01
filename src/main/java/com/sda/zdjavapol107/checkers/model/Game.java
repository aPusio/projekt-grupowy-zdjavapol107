package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private Set<Player> player;
    @ManyToOne
    private Tournament tournament;
    @OneToMany(mappedBy = "game")
    private Set<Move> moves;
    @OneToMany(mappedBy = "game")
    private Set<GamePeaces> gamePeaces;

    public Game(Set<Player> player, Tournament tournament, Set<Move> moves, Set<GamePeaces> gamePeaces) {
        this.player = player;
        this.tournament = tournament;
        this.moves = moves;
        this.gamePeaces = gamePeaces;
    }
}
