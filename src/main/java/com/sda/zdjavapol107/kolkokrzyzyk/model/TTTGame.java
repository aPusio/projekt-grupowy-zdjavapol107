package com.sda.zdjavapol107.kolkokrzyzyk.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TTTGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private TTTUser user1;
    @ManyToOne
    private TTTUser user2;
    private char user1Symbol;
    private char user2Symbol;
    private Integer user1Wins;
    private Integer user2Wins;
    @OneToMany
    private List<TTTGame> games;
}
