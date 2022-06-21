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
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Character color;
    @ManyToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private Set<Game> games;
    @OneToMany(mappedBy = "player")
    private Set<GamePeaces> gamePeaces;
    @OneToMany(mappedBy = "player")
    private Set<Move> moves;
    @ManyToOne
    private Tournament tournament;

    public Player(String name, Character color) {
        this.name = name;
        this.color = color;
    }

    public Player(String name, Tournament tournament) {
        this.name = name;
        this.tournament = tournament;
    }
}
