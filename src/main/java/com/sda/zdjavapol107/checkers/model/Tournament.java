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
    @OneToMany(mappedBy = "tournament")
    private Set<Player> players;
    private Integer playerOneScore;

    private Integer playerTwoScore;
    @OneToMany(mappedBy = "tournament")
    private Set<Game> games;


}



