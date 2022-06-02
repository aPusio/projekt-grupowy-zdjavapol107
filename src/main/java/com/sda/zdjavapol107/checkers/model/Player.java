package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private Set<Game> games;
    @OneToMany(mappedBy = "player")
    private Set<GamePeaces> gamePeaces;
    @OneToMany(mappedBy = "player")
    private Set<Move> moves;
    @ManyToOne
    private Tournament tournament;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Tournament tournament) {
        this.name = name;
        this.tournament = tournament;
    }
}
