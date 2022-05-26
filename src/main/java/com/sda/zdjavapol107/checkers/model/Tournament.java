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
    @Column(name = "player_id")
    private Integer playerId;
    private Integer score;
    @OneToMany(mappedBy = "tournament")
    private Set<Game> games;
}



