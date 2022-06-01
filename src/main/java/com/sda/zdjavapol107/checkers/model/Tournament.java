package com.sda.zdjavapol107.checkers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy = "playerOne")
    private Player playerOne;
    private Integer playerOneScore;
    @OneToOne(mappedBy = "playerOne")
    private Player playerTwo;
    private Integer playerTwoScore;
    @OneToMany(mappedBy = "tournament")
    private Set<Game> games;

    public Tournament(Player playerOne, Integer playerOneScore, Player playerTwo, Integer playerTwoScore, Set<Game> games) {
        this.playerOne = playerOne;
        this.playerOneScore = playerOneScore;
        this.playerTwo = playerTwo;
        this.playerTwoScore = playerTwoScore;
        this.games = games;
    }
}



