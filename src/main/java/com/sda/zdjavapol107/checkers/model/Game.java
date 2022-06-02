package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
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

    public Game(Set<Player> player, Tournament tournament) {
        this.player = player;
        this.tournament = tournament;
    }

}
