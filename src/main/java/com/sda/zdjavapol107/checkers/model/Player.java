package com.sda.zdjavapol107.checkers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
//    @OneToMany(mappedBy = "players")
//    private Set<Game> games;

    public Player(String name) {
        this.name = name;
    }
}
