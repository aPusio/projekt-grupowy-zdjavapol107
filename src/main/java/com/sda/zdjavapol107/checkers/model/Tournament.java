package com.sda.zdjavapol107.checkers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "tournament")
    private Set<Player> players;
    private Integer playerOneScore;

    private Integer playerTwoScore;
    @OneToMany(mappedBy = "tournament")
    private Set<Game> games;

    public Tournament(Integer playerOneScore, Integer playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }
}



