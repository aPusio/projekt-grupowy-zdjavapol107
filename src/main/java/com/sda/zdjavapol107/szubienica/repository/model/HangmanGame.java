package com.sda.zdjavapol107.szubienica.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hsqldb.rights.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "join")
@NoArgsConstructor
@Getter
@Setter
public class HangmanGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private HangmanUser gameUser;
    @ManyToMany //(mappedBy = "join")
    private Set<HangmanSlogan> slogans = new HashSet<>();
    private boolean gameStatus;

    public HangmanGame(HangmanUser gameUser,  boolean gameStatus) {
        this.gameUser = gameUser;
        this.gameStatus = gameStatus;
    }


}
